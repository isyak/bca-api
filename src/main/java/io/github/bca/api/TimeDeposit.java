package io.github.bca.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class TimeDeposit implements Serializable {

    @JsonProperty("Date")
    private Date date;

    @JsonProperty("Description1")
    private String description1;

    @JsonProperty("Description2")
    private String description2;

    @JsonProperty("Description3")
    private String description3;

    @JsonProperty("OutputData")
    private List<TimeDepositProduct> timeDepositProducts;

    public Date getDate() {
        return date;
    }

    public String getDescription1() {
        return description1;
    }

    public String getDescription2() {
        return description2;
    }

    public String getDescription3() {
        return description3;
    }

    public List<TimeDepositProduct> getTimeDepositProducts() {
        return timeDepositProducts;
    }

    @Override
    public String toString() {
        return "TimeDeposit{" +
                "date=" + date +
                ", description1='" + description1 + '\'' +
                ", description2='" + description2 + '\'' +
                ", description3='" + description3 + '\'' +
                ", timeDepositProducts='" + timeDepositProducts + '\'' +
                '}';
    }
}