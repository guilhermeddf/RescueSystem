package br.ufrn.extension.gatinhos.rescuesystem.rescue.v1;

import br.ufrn.extension.gatinhos.rescuesystem.rescue.Rescue;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.rootPath;


@ExtendWith({SpringExtension.class, MockitoExtension.class})
public class RescueControllerTest {

    @BeforeAll
    void setUp(){
        port = 8080;
        baseURI = "http://localhost:8080";
        rootPath = "/v1";
    }

    @Test
    void should_test_get_rescue_controller() throws IOException {
        List<Rescue> r = Collections.singletonList(RescueBuilder.createRescue().build());
        given().when().get("v1/rescue").then().statusCode(200);
    }

    @Test
    void should_test_post_rescue_controller() throws IOException {
        Rescue r = RescueBuilder.createRescue().build();

        given().body(r).contentType(ContentType.JSON)
                .when().post("v1/rescue").then().statusCode(HttpStatus.CREATED.value());
    }
}

