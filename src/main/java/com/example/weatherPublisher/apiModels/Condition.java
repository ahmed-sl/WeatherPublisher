package com.example.weatherPublisher.apiModels;

import lombok.Data;

@Data
class Condition {
    private String text;
    private String icon;
    private int code;

}
