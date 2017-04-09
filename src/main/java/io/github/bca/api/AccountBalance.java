package io.github.bca.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class AccountBalance implements Serializable {

    @JsonProperty("AccountDetailDataSuccess")
    private List<Account> accountList;

    @JsonProperty("AccountDetailDataFailed")
    private List<AccountError> accountErrorList;

    public List<Account> getAccountList() {
        return accountList;
    }

    public List<AccountError> getAccountErrorList() {
        return accountErrorList;
    }

    @Override
    public String toString() {
        return "AccountBalance{" +
                "accountList=" + accountList +
                ", accountErrorList=" + accountErrorList +
                '}';
    }
}