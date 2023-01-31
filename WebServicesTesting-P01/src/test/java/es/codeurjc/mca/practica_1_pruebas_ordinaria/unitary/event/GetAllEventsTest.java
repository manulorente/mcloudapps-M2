package es.codeurjc.mca.practica_1_pruebas_ordinaria.unitary.event;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import es.codeurjc.mca.practica_1_pruebas_ordinaria.unitary.AbstractControllerUnitTest;

public class GetAllEventsTest  extends AbstractControllerUnitTest{

    @Test
    @DisplayName("Get all events given any user")
    public void testGetAll() throws Exception{

        when(this.eventService.findAll()).thenReturn(events);

        mockMvc.perform(get("/api/events/")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(2)))
            .andExpect(jsonPath("$[0].name", equalTo(this.events.get(0).getName())))
            .andExpect(jsonPath("$[0].description", equalTo(this.events.get(0).getDescription())))
            .andExpect(jsonPath("$[0].price", equalTo(this.events.get(0).getPrice())))
            .andExpect(jsonPath("$[0].max_capacity", equalTo(this.events.get(0).getMax_capacity())))
            .andExpect(jsonPath("$[1].name", equalTo(this.events.get(1).getName())))
            .andExpect(jsonPath("$[1].description", equalTo(this.events.get(1).getDescription())))
            .andExpect(jsonPath("$[1].price", equalTo(this.events.get(1).getPrice())))
            .andExpect(jsonPath("$[1].max_capacity", equalTo(this.events.get(1).getMax_capacity())));
    }
}
