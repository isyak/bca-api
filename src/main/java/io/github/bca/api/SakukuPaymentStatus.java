package io.github.bca.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class SakukuPaymentStatus implements Serializable {

    @JsonProperty("PaymentID")
    private String paymentId;

    @JsonProperty("Amount")
    private BigDecimal amount;

    @JsonProperty("RequestDate")
    private Timestamp requestDate;

    @JsonProperty("PaymentStatus")
    private String paymentStatusCode;

    @JsonProperty("ReasonStatus")
    private Messages reasonStatus;

    public String getPaymentId() {
        return paymentId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Timestamp getRequestDate() {
        return requestDate;
    }

    public String getPaymentStatusCode() {
        return paymentStatusCode;
    }

    public Messages getReasonStatus() {
        return reasonStatus;
    }

    @Override
    public String toString() {
        return "SakukuPaymentStatus{" +
                "paymentId='" + paymentId + '\'' +
                ", amount=" + amount +
                ", requestDate=" + requestDate +
                ", paymentStatusCode='" + paymentStatusCode + '\'' +
                ", reasonStatus='" + reasonStatus + '\'' +
                '}';
    }
}
