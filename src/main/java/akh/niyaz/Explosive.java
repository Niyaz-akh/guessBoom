package akh.niyaz;

public enum Explosive {
    TNT(1),
    TRITONOL(1.53),
    HEXOGEN(1.3),
    PENTAERYTHRITOL_TETRANITRATE(1.39),
    AMMONOL(0.99),
    POWDER(0.66),
    LEAD_TRINITRORESORCINATE(0.39),
    TETRIL(1.15);

    private double coefficient;

    Explosive(double coefficient) {
        this.coefficient = coefficient;
    }

    public double getCoefficient() {
        return coefficient;
    }

}
