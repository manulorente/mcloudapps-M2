package es.codeurjc.mca.practica_1_pruebas_ordinaria.rest;

import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.codeurjc.mca.practica_1_pruebas_ordinaria.event.Event;
import es.codeurjc.mca.practica_1_pruebas_ordinaria.user.User;
import io.restassured.RestAssured;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class AbstractControllerRestTest {

    @LocalServerPort
    private int port;

    @Autowired
	protected ObjectMapper objectMapper;

    protected Event createEvent;

    protected User customerUser;

    protected User organizerUser;

    @BeforeEach
    public void setUp() throws Exception{
        RestAssured.port = port;
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI = "https://localhost:" + port;

        Calendar cal = Calendar.getInstance(); 
        cal.set(2023, 11, 25, 20, 0, 0);
        
        this.createEvent = new Event("Media maraton de Sevilla",
            "Carrera patrocinada por ...", 
                        cal.getTime(), 
                        20.00, 
                        12000);
        this.createEvent.setId(1L);

        this.organizerUser = new User("Pepe", "pepe@urjc.es", "pass");
        this.customerUser = new User("Juan", "juan@urjc.es", "pass");
    }
    
}
