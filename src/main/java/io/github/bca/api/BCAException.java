package io.github.bca.api;

public class BCAException extends RuntimeException {

    private String errorCode;

    private Messages messages;

    public BCAException(String errorCode, Messages messages) {

        this.errorCode = errorCode;
        this.messages = messages;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public Messages getMessages() {
        return messages;
    }

    @Override
    public String getMessage() {
        return "[" + errorCode + "] " + messages.getEnglish();
    }
}