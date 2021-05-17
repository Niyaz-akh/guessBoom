package akh.niyaz;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class BoomServiceImpl implements BoomService {
    @Override
    public double getOverpressureValue(Boom boom, double distanceToCenterExplosion) {
        final double forecastRadius = getForecastRadius(boom, distanceToCenterExplosion);
        if (forecastRadius <= 6.2)
            return overpressureValueForSmallForecastRadius(boom, forecastRadius);
        else
            return overpressureValueForBigForecastRadius(boom, forecastRadius);
    }

    private double getForecastRadius(Boom boom, double distanceToCenterExplosion) {
        double n = boom.getCoefficientUnderlyingSurface();
        double q = boom.getExplosiveMass();
        double k = boom.getCoefficientExplosiveToTNT();
        double result = distanceToCenterExplosion / Math.pow(2 * n * q * k, 1.0 / 3);

        MathContext mathContext = new MathContext(5, RoundingMode.HALF_UP);
        BigDecimal forecastRadius = new BigDecimal(result, mathContext);
        return forecastRadius.doubleValue();
    }

    private double overpressureValueForSmallForecastRadius(Boom boom, double forecastRadius) {
        MathContext mathContext = new MathContext(5, RoundingMode.HALF_UP);
        double result = 700 / (3 * (Math.sqrt(1 + Math.pow(forecastRadius, 3)) - 1));
        BigDecimal overpressure = new BigDecimal(result, mathContext);
        return overpressure.doubleValue();
    }

    private double overpressureValueForBigForecastRadius(Boom boom, double forecastRadius) {
        MathContext mathContext = new MathContext(5, RoundingMode.HALF_UP);
        double result = 70 / (forecastRadius * Math.sqrt(Math.log(forecastRadius) - 0.332));
        BigDecimal overpressure = new BigDecimal(result, mathContext);
        return overpressure.doubleValue();
    }
}
