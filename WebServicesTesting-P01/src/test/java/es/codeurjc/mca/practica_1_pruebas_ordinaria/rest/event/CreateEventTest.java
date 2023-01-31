package es.codeurjc.mca.practica_1_pruebas_ordinaria.rest.event;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import static io.restassured.RestAssured.given;

import es.codeurjc.mca.practica_1_pruebas_ordinaria.rest.AbstractControllerRestTest;

@ActiveProfiles("test")
public class CreateEventTest extends AbstractControllerRestTest {

    @Test
    @DisplayName("Create event as organizer role")
    public void testCreate() throws Exception{
        given().
            contentType("application/json").
            body(objectMapper.writeValueAsString(createEvent)).
            auth().
                basic("Patxi", "pass").
        when().
            post("/api/events/").
        then().
            statusCode(201);
    }
    
}
