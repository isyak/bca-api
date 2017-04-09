package io.github.bca.api.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.bca.api.Messages;

import java.io.Serializable;

class ErrorWrapper implements Serializable {

    @JsonProperty("ErrorCode")
    private String errorCode;

    @JsonProperty("ErrorMessage")
    private Messages messages;

    String getErrorCode() {
        return errorCode;
    }

    Messages getMessages() {
        return messages;
    }

    @Override
    public String toString() {

        return "ErrorWrapper{" +
                "errorCode='" + errorCode + '\'' +
                ", messages=" + messages +
                '}';
    }
}