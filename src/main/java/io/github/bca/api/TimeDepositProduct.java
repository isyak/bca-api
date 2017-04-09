package io.github.bca.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class TimeDepositProduct implements Serializable {

    @JsonProperty("ProductCode")
    private String productCode;

    @JsonProperty("ProductName")
    private String productName;

    @JsonProperty("Month01")
    private String month01;

    @JsonProperty("Month03")
    private String month03;

    @JsonProperty("Month06")
    private String month06;

    @JsonProperty("Month12")
    private String month12;

    public String getProductCode() {
        return productCode;
    }

    public String getProductName() {
        return productName;
    }

    public String getMonth01() {
        return month01;
    }

    public String getMonth03() {
        return month03;
    }

    public String getMonth06() {
        return month06;
    }

    public String getMonth12() {
        return month12;
    }

    @Override
    public String toString() {
        return "TimeDepositProduct{" +
                "productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", month01=" + month01 +
                ", month03=" + month03 +
                ", month06=" + month06 +
                ", month12=" + month12 +
                '}';
    }
}
