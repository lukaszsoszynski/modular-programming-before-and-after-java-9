package com.gfi.lsos.modularity.meteorologist;

import com.gfi.lsos.modularity.forecaster.Forecaster;

import java.util.ServiceLoader;

public class Application {

    public static void main(String[] args) {
        System.out.println("\n\nApplication started searching for Forecasters...\n\n");
        ServiceLoader
                .load(Forecaster.class)
                .stream()
                .forEach(Application::printForecast);
    }

    private static void printForecast(ServiceLoader.Provider<Forecaster> ForecasterProvider) {
        Class<? extends Forecaster> type = ForecasterProvider.type();
        Forecaster forecaster = ForecasterProvider.get();
        System.out.println("Forecaster: " + type.getCanonicalName());
        System.out.println("Forecast:\t" + forecaster.issueForecast());
        System.out.println("\n\n");
    }
}
