package io.github.bca.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SakukuPaymentResponse extends TransactionResponse {

    @JsonProperty("PaymentID")
    private String paymentId;

    @JsonProperty("LandingPageURL")
    private String landingPageUrl;

    public String getPaymentId() {
        return paymentId;
    }

    public String getLandingPageUrl() {
        return landingPageUrl;
    }

    @Override
    public String toString() {
        return "SakukuPaymentResponse{" +
                "transactionId='" + getTransactionId() + '\'' +
                "paymentId='" + paymentId + '\'' +
                ", landingPageUrl='" + landingPageUrl + '\'' +
                '}';
    }
}
