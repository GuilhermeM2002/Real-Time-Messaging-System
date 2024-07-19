package br.com.challenges.user.controller;

import br.com.challenges.user.application.dto.UserDto;
import io.restassured.http.ContentType;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserControllerTest {
    private UserDto user;
    private String uri;

    @BeforeEach
    public void setUp(){
        user = new UserDto();
        user.setId(new ObjectId());
        user.setUserName("Guilherme");
        user.setEmail("guilherme@email.com");
        user.setQuantityOfMessages(0);

        uri = "http://localhost:8083/user";
    }
    @Test
    public void testSaveUser(){
        given()
                .body(user)
                .contentType(ContentType.JSON)
                .when()
                .post(uri)
                .then()
                .statusCode(201)
                .log().all();
    }
    @Test
    public void testFindUserByUserName(){
        given()
                .when()
                .get(uri + "?userName=Guilherme")
                .then()
                .statusCode(200)
                .log().all();
    }
}