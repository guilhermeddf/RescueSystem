package br.ufrn.extension.gatinhos.rescuesystem.rescue.v1;

import br.ufrn.extension.gatinhos.rescuesystem.rescue.Rescue;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.restassured.http.ContentType;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.rootPath;


@ExtendWith({SpringExtension.class, MockitoExtension.class})
public class RescueControllerTest {
    public static final String BASE_FOLDER = PathMatchingResourcePatternResolver.CLASSPATH_URL_PREFIX + "/br/ufrn/extension/gatinhos/rescuesystem/rescue/";

    @BeforeAll
    void setUp(){
        port = 8080;
        baseURI = "http://localhost:8080";
        rootPath = "/v1";
    }

    @Test
    void should_test_get_rescue_controller() throws IOException {
        String folder = BASE_FOLDER;
        FileInputStream inputStream = new FileInputStream(folder + "rescue_list_all_01.json");
        String jsonData = IOUtils.toString(inputStream);
        ObjectMapper objectMapper = new ObjectMapper();
        List<Rescue> r = objectMapper.registerModule(new JavaTimeModule())
                .readValue(jsonData, new TypeReference<List<Rescue>>() {});

        given().when().get("v1/rescue").then().statusCode(200);
    }

    @Test
    void should_test_post_rescue_controller() throws IOException {
        String folder = BASE_FOLDER + "rescue\\";
        FileInputStream inputStream = new FileInputStream(folder + "rescue_post_01.json");
        String jsonData = IOUtils.toString(inputStream);
        ObjectMapper objectMapper = new ObjectMapper();
        Rescue r = objectMapper.registerModule(new JavaTimeModule())
                .readValue(jsonData, Rescue.class);

        given().body(r).contentType(ContentType.JSON)
                .when().post("v1/rescue").then().statusCode(HttpStatus.CREATED.value());
    }
}

