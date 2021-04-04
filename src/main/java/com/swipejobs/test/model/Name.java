package com.swipejobs.test.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Name {

    private String last;
    private String first;

    public String getLast() {
        return last;
    }

    public String getFirst() {
        return first;
    }
}