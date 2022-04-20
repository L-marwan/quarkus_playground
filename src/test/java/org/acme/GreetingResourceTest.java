package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @InjectMock
    GreetingConfiguration greetingConfiguration;
    @Test
    public void testHelloEndpoint() {
        Mockito.when(greetingConfiguration.getName()).thenReturn(Optional.of("mocked"));
        Mockito.when(greetingConfiguration.getMessage()).thenReturn("Salaaaam");

        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("Salaaaam mocked"));
    }

}