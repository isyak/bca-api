package io.github.bca.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountError extends Messages {

    @JsonProperty("AccountNumber")
    private String no;

    public String getNo() {
        return no;
    }

    @Override
    public String toString() {
        return "AccountError{" +
                super.toString() +
                "no='" + no + '\'' +
                '}';
    }
}