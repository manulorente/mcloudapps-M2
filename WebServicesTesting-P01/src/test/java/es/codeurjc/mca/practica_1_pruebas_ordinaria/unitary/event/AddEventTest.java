package es.codeurjc.mca.practica_1_pruebas_ordinaria.unitary.event;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;

import es.codeurjc.mca.practica_1_pruebas_ordinaria.unitary.AbstractControllerUnitTest;


public class AddEventTest  extends AbstractControllerUnitTest{

    @Test
    @DisplayName("Add event as logged user (organizer)")
    @WithMockUser(username = "user", password = "pass", roles = {"ORGANIZER"})
    public void testAdd() throws Exception{
        
        when(this.eventService.createEvent(createEvent)).thenReturn(createEvent);

        mockMvc.perform(post("/api/events/")
            .content(this.objectMapper.writeValueAsString(createEvent))
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isCreated());
    }

}
