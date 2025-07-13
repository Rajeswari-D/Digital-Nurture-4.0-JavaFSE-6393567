package com.cognizant.springlearn;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.cognizant.springlearn.controller.CountryController;

@SpringBootTest
@AutoConfigureMockMvc
public class Springlearnresth6Application {

    @Autowired
    private CountryController countryController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
        assertNotNull(countryController);
    }

    @Test
    void testGetCountry() throws Exception {
        ResultActions result = mockMvc.perform(get("/country"));

        result.andExpect(status().isOk());
        result.andExpect(jsonPath("$.code").value("IN"));
        result.andExpect(jsonPath("$.name").value("India"));
    }
	@Test
void testGetCountryByCode() throws Exception {
    mockMvc.perform(get("/countries/IN"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.code").value("IN"))
            .andExpect(jsonPath("$.name").value("India"));
}

@Test
void testGetCountryByCodeNotFound() throws Exception {
    mockMvc.perform(get("/countries/az"))
            .andExpect(status().isNotFound());
}

}
