package io.github.bca.api;

public interface Oauth2Operations {

    AccessGrant getToken(String clientId, String clientSecret);
}