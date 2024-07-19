package br.com.challenges.message.controller;

import br.com.challenges.message.avro.MessageAvro;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZoneId;
import java.util.Date;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MessageControllerTest {
    private MessageAvro messageAvro;
    private String uri;

    @BeforeEach
    public void setUp(){
        messageAvro = new MessageAvro();
        messageAvro.setDate(new Date("2024-06-07T19:08:01+00:00").toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        messageAvro.setWhoSend("Guilherme");
        messageAvro.setWhoReceive("Guilherme1");
        messageAvro.setContent("Content, content content content content");
        messageAvro.setId("1");

        uri = "http://localhost:8082/message";
    }
    @Test
    public void testSendMessage(){
        given()
                .body(messageAvro)
                .contentType(ContentType.JSON)
                .when()
                .post(uri)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void testReceiveMessage(){
        Response response = given()
                .when()
                .get(uri + "?userName=Guilherme1")
                .then()
                .statusCode(200)
                .body("id", equalTo(messageAvro.getId()))
                .body("whoSend", equalTo(messageAvro.getWhoSend()))
                .body("whoReceive", equalTo(messageAvro.getWhoReceive()))
                .body("content", equalTo(messageAvro.getContent()))
                .body("date", equalTo(messageAvro.getDate()))
                .extract()
                .response();

        System.out.println("Response Body: " + response.getBody().asString());
    }
}