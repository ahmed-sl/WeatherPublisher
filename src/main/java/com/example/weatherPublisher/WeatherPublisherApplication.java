package com.example.weatherPublisher;

import com.example.weatherPublisher.weatherGenerator.IngestionService;
import com.example.weatherPublisher.weatherGenerator.WeatherGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WeatherPublisherApplication {
	Logger logger = LoggerFactory.getLogger(WeatherPublisherApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WeatherPublisherApplication.class, args);
	}

	@Autowired
	IngestionService ingestionService;

	@Bean
	public CommandLineRunner run() {
		return args ->{
			ingestionService.ingestionData();
			logger.trace("start generate weather data");
		};
	}
}
