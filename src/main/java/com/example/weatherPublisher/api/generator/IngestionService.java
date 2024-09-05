package com.example.weatherPublisher.api.generator;


import com.example.weatherPublisher.api.model.WeatherModel;
import com.example.weatherPublisher.publisher.PublishWeatherData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IngestionService {

    private final PublishWeatherData publishWeatherData;
    private final WeatherGenerator weatherGenerator;
    private static final List<String> cities = Arrays.asList("riyadh", "jeddah", "mecca", "medina", "dammam", "khobar", "abha", "tabuk", "taif", "hail");

    public void ingestionData(){
        for (int i = 0; i < 5; i++) {
            for (String city:cities) {
                WeatherModel weatherModel = weatherGenerator.fetchData(city).toWeatherModel();
                publishWeatherData.publishWeatherData(weatherModel);
            }
        }
    }
}
