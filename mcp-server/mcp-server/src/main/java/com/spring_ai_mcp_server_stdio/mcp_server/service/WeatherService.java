package com.spring_ai_mcp_server_stdio.mcp_server.service;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    @Tool(description = "Get weather forecase for a specific latitude/longitude")
    public String getWeatherByLocation(int latitude, int longitude){
        if(latitude == 10 && longitude == 10){
            return("The weather forecast is rainy weather");
        }
        if(latitude == 20 && longitude == 20){
            return("The weather forecast is stormy weather");
        }
        return "The weather forecase is sunny weather";
    }
}
