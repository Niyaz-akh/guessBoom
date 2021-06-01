package akh.niyaz;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class BoomServiceImpl implements BoomService {
    // TODO: 02.06.2021 закончить реализацию метода
    @Override
    public double getMaxAffectedRadius(Boom boom) throws Exception {
        double overpressureValue = getOverpressureValue(boom, 1);
        throw new Exception("not implemented");
    }

    @Override
    public double getOverpressureValue(Boom boom, double distanceToCenterExplosion) {
        final double forecastRadius = getForecastRadius(boom, distanceToCenterExplosion);
        if (forecastRadius <= 6.2)
            return overpressureValueForSmallForecastRadius(forecastRadius);
        else
            return overpressureValueForBigForecastRadius(forecastRadius);
    }

    private double getForecastRadius(Boom boom, double distanceToCenterExplosion) {
        double result = distanceToCenterExplosion / getSimilarityOfCubeRootForExplosion(boom);
        MathContext mathContext = new MathContext(5, RoundingMode.HALF_UP);
        BigDecimal forecastRadius = new BigDecimal(result, mathContext);
        return forecastRadius.doubleValue();
    }

    private double getSimilarityOfCubeRootForExplosion(Boom boom) {
        double n = boom.getCoefficientUnderlyingSurface();
        double q = boom.getExplosiveMass();
        double k = boom.getCoefficientExplosiveToTNT();
        return Math.pow(2 * n * q * k, 1.0 / 3);
    }

    private double overpressureValueForSmallForecastRadius(double forecastRadius) {
        MathContext mathContext = new MathContext(5, RoundingMode.HALF_UP);
        double result = 700 / (3 * (Math.sqrt(1 + Math.pow(forecastRadius, 3)) - 1));
        BigDecimal overpressure = new BigDecimal(result, mathContext);
        return overpressure.doubleValue();
    }

    private double overpressureValueForBigForecastRadius(double forecastRadius) {
        MathContext mathContext = new MathContext(5, RoundingMode.HALF_UP);
        double result = 70 / (forecastRadius * Math.sqrt(Math.log(forecastRadius) - 0.332));
        BigDecimal overpressure = new BigDecimal(result, mathContext);
        return overpressure.doubleValue();
    }
}
