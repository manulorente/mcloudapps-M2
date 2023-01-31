package es.codeurjc.mca.practica_1_pruebas_ordinaria.rest.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

import es.codeurjc.mca.practica_1_pruebas_ordinaria.rest.AbstractControllerRestTest;
import es.codeurjc.mca.practica_1_pruebas_ordinaria.user.User;

public class CreateUserTest extends AbstractControllerRestTest{

    @Test
    @DisplayName("Create user as non authenticated user with roles customer and organizer")
    public void testCreate() throws Exception{

        Response response = null;

        response = given().
                        contentType("application/json").
                        queryParam("type", "Organizer").
                        body("{\"name\":\""+organizerUser.getName()+"\", \"email\":\""+organizerUser.getEmail()+"\", \"password\":\""+organizerUser.getPassword()+"\"}").
                        when().
                        post("/api/users/").
                        andReturn();
        assertThat(response.getStatusCode(), is(201));
        assertThat(response.getBody().jsonPath().getString("name"), is(organizerUser.getName()));
        assertThat(response.getBody().jsonPath().getString("email"), is(organizerUser.getEmail()));
        assertThat(response.getBody().jsonPath().getString("roles[0]"), is(User.ROLE_ORGANIZER));

        response = given().
                        contentType("application/json").
                        queryParam("type", "Customer").
                        body("{\"name\":\""+customerUser.getName()+"\", \"email\":\""+customerUser.getEmail()+"\", \"password\":\""+customerUser.getPassword()+"\"}").
                        when().
                        post("/api/users/").
                        andReturn();
        assertThat(response.getStatusCode(), is(201));
        assertThat(response.getBody().jsonPath().getString("name"), is(customerUser.getName()));
        assertThat(response.getBody().jsonPath().getString("email"), is(customerUser.getEmail()));
        assertThat(response.getBody().jsonPath().getString("roles[0]"), is(User.ROLE_CUSTOMER));
    }
}
