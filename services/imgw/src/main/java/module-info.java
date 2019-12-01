import com.gfi.lsos.modularity.forecaster.Forecaster;
import com.gfi.lsos.modularity.forecaster.imgw.ImgwForecaster;

module imgw {
    requires meteorologist;
    provides Forecaster with ImgwForecaster;
}