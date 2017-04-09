package io.github.bca.api;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@JsonSerialize(using = SakukuPaymentRequestSerializer.class)
public class SakukuPaymentRequest implements Serializable {

    private String merchantId;

    private String merchantName;

    private String transactionId;

    private String referenceId;

    private Timestamp requestDate;

    private BigDecimal amount;

    private BigDecimal tax;

    private String currencyCode;

    private String description;

    private String callbackUrl;

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public Timestamp getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Timestamp requestDate) {
        this.requestDate = requestDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    @Override
    public String toString() {

        return "SakukuPaymentRequest{" +
                "merchantId='" + merchantId + '\'' +
                ", merchantName='" + merchantName + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", referenceId='" + referenceId + '\'' +
                ", requestDate=" + requestDate +
                ", amount=" + amount +
                ", tax=" + tax +
                ", currencyCode='" + currencyCode + '\'' +
                ", description='" + description + '\'' +
                ", callbackUrl='" + callbackUrl + '\'' +
                '}';
    }
}
