package io.github.bca.api;

import java.util.List;

public interface GeneralInformationOperations {

    TimeDeposit getTimeDepositRates();

    List<ExchangeRate> getExchangeRates(RateType rateType);

    List<ExchangeRate> getExchangeRates(RateType rateType, String currencyCode);

    List<ATM> getNearestATM(NearestATMRequest nearestATMRequest);
}