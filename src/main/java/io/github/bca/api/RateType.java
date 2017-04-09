package io.github.bca.api;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * BCA Rate Type
 *
 * @author isyak
 */
public enum RateType {

    /**
     * Bank Notes
     */
    BANK_NOTE("BN"),

    /**
     * BCA E-Rate
     */
    E_RATE("E-RATE"),

    /**
     * Telegraphic Transfer
     */
    TT("TT"),

    /**
     * BCA Telegraphic Counter
     */
    TC("TC");

    private final String code;

    RateType(String code) {
        this.code = code;
    }

    private static Map<String, RateType> rateTypeMap = Stream.of(RateType.values()).collect(
            Collectors.toMap(s -> s.code, Function.identity()));

    @JsonCreator
    public static RateType fromString(String value) {
        return rateTypeMap.get(value);
    }

    @Override
    public String toString() {
        return code;
    }
}