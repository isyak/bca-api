package io.github.bca.api.impl;

import io.github.bca.api.*;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BusinessBankingTemplate extends AbstractBCAOperations implements BusinessBankingOperations {

    public BusinessBankingTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public AccountBalance getBalance(String corporateId, String ... accountNo) {

        List<String> pathVariables = new ArrayList<>();
        pathVariables.add(corporateId);
        pathVariables.add(StringUtils.arrayToCommaDelimitedString(accountNo));

        return restTemplate.getForObject(buildUrl("/banking/v2/corporates/{}/accounts/{}", pathVariables), AccountBalance.class);
    }

    @Override
    public AccountStatement getStatement(String corporateId, String accountNo, Date startDate, Date endDate) {

        List<String> pathVariables = new ArrayList<>();
        pathVariables.add(corporateId);
        pathVariables.add(accountNo);

        Map<String, Object> requestParam = new HashMap<>();
        requestParam.put("StartDate", formatDate(startDate));
        requestParam.put("EndDate", formatDate(endDate));

        return restTemplate.getForObject(buildUrl("/banking/v2/corporates/{}/accounts/{}/statements", pathVariables, requestParam), AccountStatement.class);
    }

    @Override
    public InhouseTransferResponse inhouseTransfer(InhouseTransferRequest inhouseTransferRequest) {

        return restTemplate.postForObject(buildUrl("/banking/corporates/transfers"), inhouseTransferRequest, InhouseTransferResponse.class);
    }

    private String formatDate(Date date) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }
}