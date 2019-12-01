import com.gfi.lsos.modularity.forecaster.Forecaster;
import com.gfi.lsos.modularity.forecaster.yr.YrForecaster;

module yr {
    requires meteorologist;
    provides Forecaster with YrForecaster;
}