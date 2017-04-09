package io.github.bca.api.impl;

import io.github.bca.api.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

public class BCATemplate implements BCA {

    private GeneralInformationOperations generalInformationOperations;

    private BusinessBankingOperations businessBankingOperations;

    private SakukuOperations sakukuOperations;

    private final RestTemplate restTemplate;

    public BCATemplate(String clientId, String clientSecret, String apiKey, String apiSecret) {

        restTemplate = createRestTemplate(clientId, clientSecret, apiKey, apiSecret);
    }

    @Override
    public GeneralInformationOperations generalInformationOperations() {

        if (generalInformationOperations == null) {
            generalInformationOperations = new GeneralInformationTemplate(restTemplate);
        }
        return generalInformationOperations;
    }

    @Override
    public BusinessBankingOperations businessBankingOperations() {

        if (businessBankingOperations == null) {
            businessBankingOperations = new BusinessBankingTemplate(restTemplate);
        }
        return businessBankingOperations;
    }

    @Override
    public SakukuOperations sakukuOperations() {

        if (sakukuOperations == null) {
            sakukuOperations = new SakukuTemplate(restTemplate);
        }
        return sakukuOperations;
    }

    private RestTemplate createRestTemplate(String clientId, String clientSecret, String apiKey, String apiSecret) {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new BCAErrorHandler());

        AccessGrant accessGrant = getAccessToken(clientId, clientSecret);
        restTemplate.setInterceptors(Collections.singletonList(new BCATransactionInterceptor(accessGrant.getAccessToken(), apiKey, apiSecret)));
        return restTemplate;
    }

    protected AccessGrant getAccessToken(String clientId, String clientSecret) {

        Oauth2Operations oauth2Operations = new Oauth2Template();
        return oauth2Operations.getToken(clientId, clientSecret);
    }
}