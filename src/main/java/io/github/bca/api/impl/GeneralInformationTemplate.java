package io.github.bca.api.impl;

import io.github.bca.api.*;
import org.springframework.web.client.RestTemplate;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GeneralInformationTemplate extends AbstractBCAOperations implements GeneralInformationOperations {

    public GeneralInformationTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public TimeDeposit getTimeDepositRates() {

        return restTemplate.getForObject(buildUrl("/general/rate/deposit"), TimeDeposit.class);
    }

    @Override
    public List<ExchangeRate> getExchangeRates(RateType rateType) {
        return getExchangeRates(rateType, "");
    }

    @Override
    public List<ExchangeRate> getExchangeRates(RateType rateType, String currencyCode) {

        Map<String, Object> requestParam = new HashMap<>();
        requestParam.put("RateType", rateType);
        requestParam.put("Currency", currencyCode);

        return restTemplate.getForObject(buildUrl("/general/rate/forex", requestParam), ExchangeRateResponseWrapper.class).getExchangeRateList();
    }

    @Override
    public List<ATM> getNearestATM(NearestATMRequest nearestATMRequest) {

        Map<String, Object> requestParam = new HashMap<>();
        requestParam.put("SearchBy", "Distance");
        requestParam.put("Latitude", formatPosition(nearestATMRequest.getLatitude()));
        requestParam.put("Longitude", formatPosition(nearestATMRequest.getLongitude()));
        requestParam.put("Radius", nearestATMRequest.getRadius());
        requestParam.put("Count", nearestATMRequest.getCount());

        return restTemplate.getForObject(buildUrl("/general/info-bca/atm", requestParam), NearestATMResponseWrapper.class).getAtmList();
    }

    private String formatPosition(double value) {

        NumberFormat formatter = new DecimalFormat("#.0000000");
        formatter.setMinimumFractionDigits(6);
        return formatter.format(value);
    }
}