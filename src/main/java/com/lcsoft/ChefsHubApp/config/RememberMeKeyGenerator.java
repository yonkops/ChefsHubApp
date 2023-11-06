package com.lcsoft.ChefsHubApp.config;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class RememberMeKeyGenerator {
    private final SecureRandom random = new SecureRandom();
    private final byte[] keyBytes = new byte[64]; // Дължина на ключа в байтове
    private final String rememberMeKey;

    public RememberMeKeyGenerator() {
        random.nextBytes(keyBytes);
        rememberMeKey = new String(keyBytes);
    }

    public String getRememberMeKey() {
        return rememberMeKey;
    }

}
