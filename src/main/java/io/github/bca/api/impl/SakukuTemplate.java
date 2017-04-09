package io.github.bca.api.impl;

import io.github.bca.api.SakukuOperations;
import io.github.bca.api.SakukuPaymentRequest;
import io.github.bca.api.SakukuPaymentResponse;
import io.github.bca.api.SakukuPaymentStatus;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class SakukuTemplate extends AbstractBCAOperations implements SakukuOperations {

    public SakukuTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public SakukuPaymentResponse create(SakukuPaymentRequest sakukuPaymentRequest) {

        return restTemplate.postForObject(buildUrl("/sakuku-commerce/payments"), sakukuPaymentRequest, SakukuPaymentResponse.class);
    }

    @Override
    public SakukuPaymentStatus getStatus(String merchantId, String paymentId) {

        List<String> pathVariables = new ArrayList<>();
        pathVariables.add(merchantId);
        pathVariables.add(paymentId);

        return restTemplate.getForObject(buildUrl("/sakuku-commerce/payments/{}/{}", pathVariables), SakukuPaymentStatus.class);
    }
}