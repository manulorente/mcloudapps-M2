package es.codeurjc.mca.practica_1_pruebas_ordinaria.rest.ticket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

import es.codeurjc.mca.practica_1_pruebas_ordinaria.rest.AbstractControllerRestTest;

public class DeleteTicketTest extends AbstractControllerRestTest{

    @Test
    @DisplayName("Delete ticket as customer role")
    public void deleteTicket() throws Exception{

        Response response = null;

        int numberOfTickets = 5;

        long eventId = 4L;

        for (int i = 0; i < numberOfTickets; i++) {
            response = given().
                        contentType("application/json").
                        queryParam("eventId", eventId).
                        auth().
                            basic("Michel", "pass").
                        post("/api/tickets/").
                        andReturn();
            assertThat(response.getStatusCode(), is(201));
        }

        for (int i = 4 + numberOfTickets; i > 4; i--) {
            response = given().
                            contentType("application/json").
                            auth().
                                basic("Michel", "pass").
                            delete("/api/tickets/{id}", (long) i).
                            andReturn();
            assertThat(response.getStatusCode(), is(200));
            assertThat(response.getBody().asString(), is("Ticket deleted successfully"));

            response = given().
                            contentType("application/json").
                            queryParam("eventId", eventId).
                            auth().
                                basic("Michel", "pass").
                            get("/api/events/").
                            andReturn();
            assertThat(response.getStatusCode(), is(200));
            assertThat(response.getBody().jsonPath().getList("current_capacity").get(0), is(i - 5));
        }
    }
    
}
