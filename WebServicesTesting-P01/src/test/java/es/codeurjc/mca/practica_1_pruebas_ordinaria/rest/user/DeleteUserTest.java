package es.codeurjc.mca.practica_1_pruebas_ordinaria.rest.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

import es.codeurjc.mca.practica_1_pruebas_ordinaria.rest.AbstractControllerRestTest;

public class DeleteUserTest extends AbstractControllerRestTest{

    @Test
    @DisplayName("Delete user as admin")
    public void testDelete() throws Exception{

        Response response = null;

        response = given().
                        contentType("application/json").
                        auth().
                            basic("admin", "pass").
                        delete("/api/users/{id}", 2L).
                        andReturn();
        assertThat(response.getStatusCode(), is(204));

        response = given().
                        contentType("application/json").
                        auth().
                            basic("admin", "pass").
                        delete("/api/users/{id}", 3L).
                        andReturn();
        assertThat(response.getStatusCode(), is(204));

    }
    
}
