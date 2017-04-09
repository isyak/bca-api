package io.github.bca.api;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum TransactionType {

    /**
     * Debit Type
     */
    DEBIT("D"),

    /**
     * Credit Type
     */
    CREDIT("C");

    private final String code;

    TransactionType(String code) {
        this.code = code;
    }

    private static Map<String, TransactionType> transactionTypeMap = Stream.of(TransactionType.values()).collect(Collectors.toMap(s -> s.code, Function.identity()));

    @JsonCreator
    public static TransactionType fromString(String value) {
        return transactionTypeMap.get(value);
    }

    @Override
    public String toString() {
        return code;
    }
}