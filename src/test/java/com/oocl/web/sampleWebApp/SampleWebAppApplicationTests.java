package com.oocl.web.sampleWebApp;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class SampleWebAppApplicationTests {

    private static final String objectMapper = null;
	@Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform
        (get("/"))
        .andDo(print())
        .andExpect
        (status().isOk())
                .andExpect(content().string(containsString("Hello World")));
    }
    @Test
    public void shouldReturnBadMessage() throws Exception {
        this.mockMvc.perform
        (get("/hello"))
        .andDo(print())
        .andExpect
        (status().isOk())
                .andExpect(
                		content().string(containsString("Hello World"))
                		);
    }
    @Test
    public void shouldReturnUserMessage() throws Exception {
        this.mockMvc.perform
        (get("/user"))
        .andDo(print())
        .andExpect
        (status().isOk())
                .andExpect(
                		MockMvcResultMatchers.jsonPath("$.user",CoreMatchers.is("¿Ó“ª“ª"))
                		);
    }

}