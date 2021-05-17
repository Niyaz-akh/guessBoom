package akh.niyaz;

public class Boom {
    private final double explosiveMass;
    private final UnderlyingSurface underlyingSurface;
    private final Explosive explosive;
    private final double coefficientUnderlyingSurface;
    private final double coefficientExplosiveToTNT;

    public Boom(double explosiveMass, UnderlyingSurface underlyingSurface, Explosive explosive) {
        this.explosiveMass = explosiveMass;
        this.underlyingSurface = underlyingSurface;
        this.explosive = explosive;
        coefficientUnderlyingSurface = underlyingSurface.getCoefficient();
        coefficientExplosiveToTNT = explosive.getCoefficient();
    }


    public double getExplosiveMass() {
        return explosiveMass;
    }

    public UnderlyingSurface getUnderlyingSurface() {
        return underlyingSurface;
    }

    public Explosive getExplosive() {
        return explosive;
    }

    public double getCoefficientUnderlyingSurface() {
        return coefficientUnderlyingSurface;
    }

    public double getCoefficientExplosiveToTNT() {
        return coefficientExplosiveToTNT;
    }

    @Override
    public String toString() {
        return "Boom{" +
                "explosiveMass=" + explosiveMass +
                ", underlyingSurface=" + underlyingSurface +
                ", explosive=" + explosive +
                ", coefficientUnderlyingSurface=" + coefficientUnderlyingSurface +
                ", coefficientExplosiveToTNT=" + coefficientExplosiveToTNT +
                '}';
    }
}
