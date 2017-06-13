package com.claurier.securitybasic.modules.security.controller;

/**
 * Created by CARL on 09/06/2017.
 */
import java.io.Serializable;

public class JwtAuthenticationResponse
        implements Serializable {
    private static final long serialVersionUID = 1250166508152483573L;
    private final String token;

    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}
