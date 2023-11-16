package com.lcsoft.ChefsHubApp.usertests;

import com.lcsoft.ChefsHubApp.model.dto.LoginFormDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class LoginControllerTest {

    @Autowired
    private ObjectMapper objectMapper;
    private final MockMvc mockMvc;

    LoginControllerTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    @DisplayName("Логин с валидни данни")
    void loginWithValidData() throws Exception {
        // Инициализираме данните за логина
        LoginFormDto loginRequest = new LoginFormDto();
        loginRequest.setEmail("johndoe@example.com");
        loginRequest.setPassword("password");

        // Изпращаме заявката за логин
        mockMvc.perform(post("/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.username").value("johndoe"))
                .andExpect(jsonPath("$.data.roles").value("ROLE_USER"));
    }

    @Test
    @DisplayName("Логин с невалидни данни")
    void loginWithInvalidData() throws Exception {
        // Инициализираме данните за логина
        LoginFormDto loginRequest = new LoginFormDto();
        loginRequest.setEmail("invalid-email");
        loginRequest.setPassword("invalid-password");

        // Изпращаме заявката за логин
        mockMvc.perform(post("/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginRequest)))
                .andExpect(status().isUnauthorized())
                .andExpect(jsonPath("$.success").value(false))
                .andExpect(jsonPath("$.errors").value("Invalid email or password"));
    }
}