package io.github.bca.api.impl;

import io.github.bca.api.AccessGrant;
import io.github.bca.api.Oauth2Operations;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

public class Oauth2Template extends AbstractBCAOperations implements Oauth2Operations {

    public Oauth2Template() {

        this.restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new BCAErrorHandler());
    }

    public AccessGrant getToken(String clientId, String clientSecret) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("Authorization", getAuthorization(clientId, clientSecret));

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "client_credentials");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body, headers);

        return restTemplate.postForObject(buildUrl("/api/oauth/token"), request, AccessGrant.class);
    }

    private String getAuthorization(String clientId, String clientSecret) {

        return "Basic " + Base64.getEncoder().encodeToString((clientId + ":" + clientSecret).getBytes());
    }
}