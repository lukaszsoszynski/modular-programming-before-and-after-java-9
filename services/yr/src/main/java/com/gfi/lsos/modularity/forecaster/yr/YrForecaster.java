package com.gfi.lsos.modularity.forecaster.yr;

import com.gfi.lsos.modularity.forecaster.Forecaster;

import java.util.Random;

public class YrForecaster implements Forecaster {

    private final Random random = new Random();

    @Override
    public String issueForecast() {
        int temperature = random.nextInt(70) - 35;
        double wind = random.nextDouble() * 35.0;
        double rain = random.nextDouble() * 20.0;
        int probability = random.nextInt(100);
        return String.format("temperature %d, wind %f, m/s, rain %f, probability %d %%.", temperature, wind, rain, probability);
    }
}
