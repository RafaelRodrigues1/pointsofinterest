package com.desafios.backendbr.pointsofinterest.infrastructure.controllers;

import com.desafios.backendbr.pointsofinterest.application.models.PointOfInterest;
import com.desafios.backendbr.pointsofinterest.application.ports.PointOfInterestDataSourcePort;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.desafios.backendbr.pointsofinterest.application.models.PointOfInterestFactory.createASetOfValidPointOfInterest;
import static com.desafios.backendbr.pointsofinterest.infrastructure.dtos.PointOfInterestDTOFactory.createAValidPointOfInterestDTO;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class PointOfInterestControllerTest {

    @MockBean
    private PointOfInterestDataSourcePort pointOfInterestDataSourcePort;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldReturnStatusOkWhenSavePoiWithSuccess() throws Exception {
        doNothing().when(pointOfInterestDataSourcePort).save(any(PointOfInterest.class));
        var content = objectMapper.writeValueAsString(createAValidPointOfInterestDTO());

        var response = mockMvc.perform(post("/poi")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(content));

        response.andExpect(status().isOk());
        verify(pointOfInterestDataSourcePort, times(1)).save(any(PointOfInterest.class));
    }

    @Test
    void shouldReturnSetOfPoiAndStatusOkWhenCallGetAllPointOfInterest() throws Exception {
        when(pointOfInterestDataSourcePort.getAllPointOfInterests()).thenReturn(createASetOfValidPointOfInterest());

        var response = mockMvc.perform(get("/poi")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        response
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(createASetOfValidPointOfInterest().size())));
        verify(pointOfInterestDataSourcePort, times(1)).getAllPointOfInterests();
    }

    @Test
    void shouldReturnSetOfPoiAndStatusOkWhenCallGetPointsOfInterestNearMe() throws Exception {
        when(pointOfInterestDataSourcePort
                .searchNearbyPointsOfInterest(anyInt(), anyInt(), anyInt()))
                .thenReturn(createASetOfValidPointOfInterest());

        var response = mockMvc.perform(get("/poi/nearby")
                        .param("maxDistance", "10")
                        .param("x", "20")
                        .param("y", "30")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        response
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(createASetOfValidPointOfInterest().size())));
        verify(pointOfInterestDataSourcePort, times(1)).searchNearbyPointsOfInterest(anyInt(), anyInt(), anyInt());
    }
}
