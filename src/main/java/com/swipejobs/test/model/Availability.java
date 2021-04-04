package com.swipejobs.test.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Availability {

    private String title;
    private Integer dayIndex;

    public String getTitle() {
        return title;
    }

    public Integer getDayIndex() {
        return dayIndex;
    }
}