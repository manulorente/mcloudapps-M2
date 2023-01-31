package es.codeurjc.mca.practica_1_pruebas_ordinaria.unitary.event;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;

import es.codeurjc.mca.practica_1_pruebas_ordinaria.unitary.AbstractControllerUnitTest;

public class DeleteEventTest  extends AbstractControllerUnitTest{

    @Test
    @DisplayName("Delete event as logged user (admin)")
    @WithMockUser(username = "user", password = "pass", roles = {"ADMIN"})
    public void testDelete() throws Exception{

        when(userService.getMe()).thenReturn(userAdmin);
        when(this.eventRepository.findById(1L)).thenReturn(Optional.of(this.events.get(0)));
        doNothing().when(this.eventRepository).delete(this.events.get(0));
    
        mockMvc.perform(delete("/api/events/{id}", 1L)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    }
    
}
