package com.gfi.lsos.modularity.forecaster.meteo;

import com.gfi.lsos.modularity.forecaster.Forecaster;

import java.util.Random;

public class MeteoForecaster implements Forecaster {

    private static String[] FORECASTS = {"sun", "rain", "snow", "wind"};
    private final Random random = new Random();

    @Override
    public String issueForecast() {
        return FORECASTS[random.nextInt(FORECASTS.length)];
    }
}
