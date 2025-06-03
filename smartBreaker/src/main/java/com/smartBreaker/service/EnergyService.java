package com.smartBreaker.service;

import com.smartBreaker.model.EnergyStatusResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class EnergyService {

    @Value("${openweather.api.key}")
    private String apiKey;

    @Value("${openweather.api.weather.url}")
    private String weatherUrl;

    private final RestTemplate restTemplate;

    public EnergyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public EnergyStatusResponse getStatusByCoordinates(double lat, double lon) {
        String url = weatherUrl + "?lat=" + lat + "&lon=" + lon +
                "&appid=" + apiKey + "&units=metric&lang=pt_br";

        Map response = restTemplate.getForObject(url, Map.class);

        String description = (String) ((Map) ((List) response.get("weather")).get(0)).get("description");
        double temp = ((Map<String, Number>) response.get("main")).get("temp").doubleValue();

        String status = getEnergyStatus(description);

        EnergyStatusResponse result = new EnergyStatusResponse();
        result.setWeatherDescription(description);
        result.setTemperature(temp);
        result.setStatus(status);

        return result;
    }

    private String getEnergyStatus(String description) {
        if (description.contains("chuva") || description.contains("tempestade") || description.contains("nuvens")) {
            return "instável";
        }
        return "estável";
    }
}
