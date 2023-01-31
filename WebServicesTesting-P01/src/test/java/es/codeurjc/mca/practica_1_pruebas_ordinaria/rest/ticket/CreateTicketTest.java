package es.codeurjc.mca.practica_1_pruebas_ordinaria.rest.ticket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

import es.codeurjc.mca.practica_1_pruebas_ordinaria.rest.AbstractControllerRestTest;

public class CreateTicketTest extends AbstractControllerRestTest{
   
    @Test
    @DisplayName("Create ticket as customer role")
    public void createTicket() throws Exception{

        Response response = null;

        for (int i = 0; i < 3; i++) {
            response = given().
                            contentType("application/json").
                            queryParam("eventId", 4L).
                            auth().
                                basic("Michel", "pass").
                            post("/api/tickets/").
                            andReturn();
            assertThat(response.getStatusCode(), is(201));
            assertThat(response.getBody().jsonPath().get("event.current_capacity"), is(i+1));
        }
    }
}
