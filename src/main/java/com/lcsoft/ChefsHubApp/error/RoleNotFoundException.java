package com.lcsoft.ChefsHubApp.error;

public class RoleNotFoundException extends RuntimeException {
    public RoleNotFoundException(String message) {
        super (message);
    }
}
