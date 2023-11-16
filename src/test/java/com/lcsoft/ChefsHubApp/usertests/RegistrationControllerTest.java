package com.lcsoft.ChefsHubApp.usertests;



import com.lcsoft.ChefsHubApp.model.dto.UserRegistrationDto;
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
public class RegistrationControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;
    public RegistrationControllerTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }


    @Test
    @DisplayName("Регистрация с валидни данни")
    void registerWithValidData() throws Exception {
        // Инициализираме данните за регистрацията
        UserRegistrationDto registrationRequest = new UserRegistrationDto();
        registrationRequest.setEmail("johndoe@example.com");
        registrationRequest.setPassword("password");

        // Изпращаме заявката за регистрация
        mockMvc.perform(post("/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(registrationRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.username").value("johndoe"));
    }

    @Test
    @DisplayName("Регистрация с невалидни данни")
    void registerWithInvalidData() throws Exception {
        // Инициализираме данните за регистрацията
        UserRegistrationDto registrationRequest = new UserRegistrationDto();
        registrationRequest.setEmail("invalid-email");
        registrationRequest.setPassword("invalid-password");

        // Изпращаме заявката за регистрация
        mockMvc.perform(post("/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(registrationRequest)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.success").value(false))
                .andExpect(jsonPath("$.errors").value("Invalid email or password"));
    }
}