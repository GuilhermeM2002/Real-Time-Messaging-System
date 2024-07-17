package br.com.challenges.message.application.useCaseImpl.integrationTests;

import br.com.challenges.message.avro.MessageAvro;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@EmbeddedKafka(partitions = 1, topics = "topic-test")
class SendMessageUseCaseImplTest {
    @Autowired
    private KafkaTemplate<String, MessageAvro> kafkaTemplate;
    private BlockingQueue<ConsumerRecord<String, MessageAvro>> records;

    @BeforeEach
    public void setup() {
        records = new LinkedBlockingQueue<>();
    }

    @Test
    public void testProcessesMessage() throws InterruptedException {
        MessageAvro messageAvro = new MessageAvro();
        messageAvro.setWhoSend("guilherme");
        messageAvro.setWhoReceive("guilherme1");
        messageAvro.setContent("Content content content content");
        messageAvro.setDate(new Date("2024-06-07T19:08:01+00:00").toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

        kafkaTemplate.send("test-topic", messageAvro);
        ConsumerRecord<String, MessageAvro> received = records.poll(10, TimeUnit.SECONDS);
        assertEquals(messageAvro.getId(), received.value().getId());
        assertEquals(messageAvro.getContent(), received.value().getContent());
    }
    @KafkaListener(topics = "test_topic")
    public void listen(ConsumerRecord<String, MessageAvro> record) {
        records.add(record);
    }
}