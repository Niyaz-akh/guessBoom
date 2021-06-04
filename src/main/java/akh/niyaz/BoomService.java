package akh.niyaz;

public interface BoomService {
    double getMaxAffectedRadius(Boom boom);
    double getOverpressureValue(Boom boom, double distanceToCenterExplosion);
}
