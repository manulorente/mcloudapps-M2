package es.codeurjc.mca.practica_1_pruebas_ordinaria.unitary;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.codeurjc.mca.practica_1_pruebas_ordinaria.event.Event;
import es.codeurjc.mca.practica_1_pruebas_ordinaria.event.EventRepository;
import es.codeurjc.mca.practica_1_pruebas_ordinaria.event.EventService;
import es.codeurjc.mca.practica_1_pruebas_ordinaria.image.LocalImageService;
import es.codeurjc.mca.practica_1_pruebas_ordinaria.user.User;
import es.codeurjc.mca.practica_1_pruebas_ordinaria.user.UserService;

@SpringBootTest
@AutoConfigureMockMvc
public abstract class AbstractControllerUnitTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
	protected ObjectMapper objectMapper;

    @Autowired
    protected EventService eventService;

    @MockBean
    protected EventRepository eventRepository;

    @MockBean
    protected UserService userService;

    @MockBean
    protected LocalImageService localImageService;

    protected List<Event> events;
    protected Event createEvent;
    protected User userAdmin;

    @BeforeEach
    public void setUp() throws Exception{

        Calendar cal = Calendar.getInstance(); 
        cal.set(2023, 11, 25, 20, 0, 0);

        events = Arrays.asList(
            new Event("Concierto municipal de Castilleja", 
                        "Concierto ofrecido por ...", 
                        cal.getTime(), 
                        19.99, 
                        50),
            new Event("Partido de futbol del Sevilla", 
                        "Cuartos de final", 
                        cal.getTime(), 
                        15.99, 
                        20000));

        createEvent = new Event("Media maraton de Sevilla",
            "Carrera patrocinada por ...", 
                        cal.getTime(), 
                        20.00, 
                        12000);

        userAdmin = new User("admin", "admin@urjc.es", "pass", User.ROLE_ADMIN);

        for (Event event : this.events) {
            event.setId((long) this.events.indexOf(event));
            event.setCreator(userAdmin);
        }

        this.createEvent.setId((long) this.events.size() + 1);
    }

}