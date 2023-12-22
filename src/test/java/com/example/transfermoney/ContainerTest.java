package com.example.transfermoney;
import com.example.transfermoney.advice.ErrorResponse;
import com.example.transfermoney.model.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import java.util.Objects;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ContainerTest{
    @Autowired
    TestRestTemplate restTemplate;
    private static final GenericContainer<?> prodApp = new GenericContainer<>("app:latest").withExposedPorts(5500);
    @BeforeAll
    public static void setUp(){
        prodApp.start();
    }
    @AfterAll
    public static void setDown(){
        prodApp.stop();
    }
    @Test
    void appDoTransferTest(){
        Transfer transfer = new Transfer(
                new Amount(Currency.RUR, 500L),
                "345",
                "0000111122223333",
                "12/24",
                "0000111122224444"
        );
        OperationResponse response = restTemplate.postForObject("http://localhost:" + prodApp.getMappedPort(5500) + "/transfer",transfer, OperationResponse.class);
        Assertions.assertEquals(response.getOperationId(), 1 + "");
    }
    @Test
    void appValidTransferTest(){
        Transfer transfer = new Transfer(
                new Amount(Currency.RUR, 500L),
                null,
                "",
                "",
                ""
        );
        ResponseEntity<ErrorResponse> response = restTemplate.postForEntity("http://localhost:" + prodApp.getMappedPort(5500) + "/transfer",transfer, ErrorResponse.class);
        Assertions.assertEquals(Objects.requireNonNull(response.getBody()).getId(), 1 );
    }
    @Test
    void appConfirmOperationTest(){
        ConfirmInfo confirmInfo = new ConfirmInfo();
        confirmInfo.setOperationId("1");
        confirmInfo.setCode("0000");
        OperationResponse response = restTemplate.postForObject("http://localhost:" + prodApp.getMappedPort(5500) + "/confirmOperation",confirmInfo, OperationResponse.class);
        Assertions.assertEquals(response.getOperationId(), 1 + "");
    }
}