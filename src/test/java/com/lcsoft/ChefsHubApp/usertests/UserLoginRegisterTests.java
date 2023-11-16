package com.lcsoft.ChefsHubApp.usertests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserLoginRegisterTests {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String loginUrl;
    private String registerUrl;

    @Before
    public void setup() {
        loginUrl = "http://localhost:" + port + "/users/login"; // Подходящ URL за вашето приложение
        registerUrl = "http://localhost:" + port + "/users/register"; // Подходящ URL за вашето приложение
    }

    @Test
    public void testSuccessfulLogin() {
        // Подготвяме заявката за успешно логване
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        // Подготвяме параметрите за логване
        MultiValueMap<String, String> loginParams = new LinkedMultiValueMap<>();
        loginParams.add("username", "usertest@email.com");
        loginParams.add("password", "passwordtest");

        HttpEntity<MultiValueMap<String, String>> loginRequest = new HttpEntity<>(loginParams, headers);

        ResponseEntity<String> loginResponse = restTemplate.exchange(loginUrl, HttpMethod.POST, loginRequest, String.class);

        // Проверяваме дали логването е успешно (очакваме HTTP статус 200 OK)
        assertThat(loginResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void testSuccessfulRegistration() {
        // Подготвяме заявката за успешна регистрация
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        // Подготвяме параметрите за регистрация
        MultiValueMap<String, String> registerParams = new LinkedMultiValueMap<>();
        registerParams.add("username", "usertest@email.com");
        registerParams.add("password", "passwordtest");
        registerParams.add("firstName", "test2");
        registerParams.add("lastName", "test22");

        HttpEntity<MultiValueMap<String, String>> registerRequest = new HttpEntity<>(registerParams, headers);

        ResponseEntity<String> registerResponse = restTemplate.exchange(registerUrl, HttpMethod.POST, registerRequest, String.class);

        // Проверяваме дали регистрацията е успешна (очакваме HTTP статус 200 OK)
        assertThat(registerResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}

