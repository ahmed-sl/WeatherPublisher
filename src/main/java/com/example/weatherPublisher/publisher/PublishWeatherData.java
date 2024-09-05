package com.example.weatherPublisher.publisher;

import com.example.weatherPublisher.api.model.WeatherModel;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PublishWeatherData {

    Logger logger = LoggerFactory.getLogger(PublishWeatherData.class);

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final RestTemplate restTemplate = new RestTemplate();
    private static final List<String> cities = Arrays.asList("riyadh", "jeddah", "mecca", "medina", "dammam", "khobar", "abha", "tabuk", "taif", "hail");
    @Value("${api.key}")
    private String API_KEY;

    public void publishWeatherData(WeatherModel weatherModels) {
        kafkaTemplate.send("weather", weatherModels.toString());
        logger.trace("publish data successfully");
    }
}

