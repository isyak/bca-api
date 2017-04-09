package io.github.bca.api;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

@JsonSerialize(using = InhouseTransferRequestSerializer.class)
public class InhouseTransferRequest implements Serializable {

    private String corporateId;

    private String accountNo;

    private String transactionId;

    private Date transactionDate;

    private String referenceId;

    private String currencyCode;

    private BigDecimal amount;

    private String beneficiaryAccountNo;

    private String remark1;

    private String remark2;

    public String getCorporateId() {
        return corporateId;
    }

    public void setCorporateId(String corporateId) {
        this.corporateId = corporateId;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getBeneficiaryAccountNo() {
        return beneficiaryAccountNo;
    }

    public void setBeneficiaryAccountNo(String beneficiaryAccountNo) {
        this.beneficiaryAccountNo = beneficiaryAccountNo;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    @Override
    public String toString() {
        return "InhouseTransferRequest{" +
                "corporateId='" + corporateId + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", transactionDate=" + transactionDate +
                ", referenceId='" + referenceId + '\'' +
                ", currencyCode='" + currencyCode + '\'' +
                ", amount=" + amount +
                ", beneficiaryAccountNo='" + beneficiaryAccountNo + '\'' +
                ", remark1='" + remark1 + '\'' +
                ", remark2='" + remark2 + '\'' +
                '}';
    }
}
