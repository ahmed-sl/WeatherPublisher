package com.example.weatherPublisher.api.model;

import lombok.Data;

@Data
class Condition {
    private long code;
    private String icon;
    private String text;

}
