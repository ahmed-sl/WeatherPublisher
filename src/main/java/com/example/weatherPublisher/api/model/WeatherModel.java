package com.example.weatherPublisher.api.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WeatherModel {
    private UUID id;
    private String location;
    private double latitude;
    private double longitude;
    private String date;
    private double degree;
}

