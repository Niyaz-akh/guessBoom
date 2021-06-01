package akh.niyaz;


public class App {
    public static void main(String[] args) {
        final double distanceToCenterExplosion = 0.0001;
        final double explosiveMass = 10;
        final UnderlyingSurface underlyingSurface = UnderlyingSurface.SOIL;
        final Explosive explosive = Explosive.TRITONOL;
        final BoomService boomService = new BoomServiceImpl();

        Boom boom = new Boom(explosiveMass, underlyingSurface, explosive);
        double overpressureValue = boomService.getOverpressureValue(boom, distanceToCenterExplosion);

        System.out.println("For explosion " + boom + "\nin distance to center explosion "
                + distanceToCenterExplosion + "\noverpressure value = " + overpressureValue);

    }
}
