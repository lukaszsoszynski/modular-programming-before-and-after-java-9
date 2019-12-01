import com.gfi.lsos.modularity.forecaster.Forecaster;
import com.gfi.lsos.modularity.forecaster.meteo.MeteoForecaster;

module meteo {
    requires meteorologist;
    provides Forecaster with MeteoForecaster;
}