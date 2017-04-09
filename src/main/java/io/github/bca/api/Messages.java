package io.github.bca.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Messages implements Serializable {

    @JsonProperty("Indonesian")
    private String indonesian;

    @JsonProperty("English")
    private String english;

    public String getIndonesian() {
        return indonesian;
    }

    public String getEnglish() {
        return english;
    }

    @Override
    public String toString() {
        return "Messages{" +
                "indonesian='" + indonesian + '\'' +
                ", english='" + english + '\'' +
                '}';
    }
}