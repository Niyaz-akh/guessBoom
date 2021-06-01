package akh.niyaz;

public interface BoomService {
    double getMaxAffectedRadius(Boom boom) throws Exception;
    double getOverpressureValue(Boom boom, double distanceToCenterExplosion);
}
