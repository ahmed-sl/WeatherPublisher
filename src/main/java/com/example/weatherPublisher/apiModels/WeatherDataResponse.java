// WeatherData.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

package com.example.weatherPublisher.apiModels;

import com.example.weatherPublisher.model.WeatherModel;
import lombok.Data;

import java.util.UUID;

@Data
public class WeatherDataResponse {
    private Location location;
    private Current current;

    public WeatherModel toWeatherModel(){
        return new WeatherModel(
                UUID.randomUUID(),
                location.getName(),
                location.getLat(),
                location.getLon(),
                location.getLocaltime(),
                current.getTemp_c()
        );
    }
}

