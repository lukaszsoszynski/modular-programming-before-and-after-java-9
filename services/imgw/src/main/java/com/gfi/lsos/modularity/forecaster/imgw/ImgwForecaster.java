package com.gfi.lsos.modularity.forecaster.imgw;

import com.gfi.lsos.modularity.forecaster.Forecaster;

import java.util.Random;
import java.util.stream.Stream;

public class ImgwForecaster implements Forecaster {

    private final Random random = new Random();

    private final static Stream<String> FORECAST = Stream.of("breeze",
            "twister",
            "hurricane",
            "drizzle",
            "torrential rain",
            "stifling",
            "scorching");


    @Override
    public String issueForecast() {
        return FORECAST.reduce("", (one, two) -> random.nextDouble() <= .5 ? one : two);
    }
}
