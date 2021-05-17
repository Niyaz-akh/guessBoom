package akh.niyaz;

public enum UnderlyingSurface {
    METAL(1.0),
    CONCRETE(0.95),
    WOOD(0.8),
    SOIL(0.6);

    private double coefficient;

    UnderlyingSurface(double coefficient) {
        this.coefficient = coefficient;
    }

    public double getCoefficient() {
        return coefficient;
    }
}
