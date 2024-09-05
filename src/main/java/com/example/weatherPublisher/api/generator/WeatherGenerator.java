package com.example.weatherPublisher.api.generator;


import com.example.weatherPublisher.api.model.WeatherDataResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherGenerator {
    Logger logger = LoggerFactory.getLogger(WeatherGenerator.class);
    private final RestTemplate restTemplate = new RestTemplate();
    @Value("${api.key}")
    private String API_KEY;

    public WeatherDataResponse fetchData(String city) {
        logger.trace("start fetch data for: " + city);
        String url = String.format("https://api.weatherapi.com/v1/current.json?key=%s&q=%s&aqi=no", API_KEY, city);
        return restTemplate.getForObject(url, WeatherDataResponse.class);

    }
}
