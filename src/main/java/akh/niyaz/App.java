package akh.niyaz;


public class App {
    public static void main(String[] args) {
        final double distanceToCenterExplosion = 7.9;
        final double explosiveMass = 58;
        final UnderlyingSurface underlyingSurface = UnderlyingSurface.METAL;
        final Explosive explosive = Explosive.TNT;
        final BoomService boomService = new BoomServiceImpl();

        Boom boom = new Boom(explosiveMass, underlyingSurface, explosive);
        double overpressureValue = boomService.getOverpressureValue(boom, distanceToCenterExplosion);
        double maxAffectedRadius = boomService.getMaxAffectedRadius(boom);

        System.out.println("For explosion " + boom + "\nin distance to center explosion "
                + distanceToCenterExplosion + "\noverpressure value = " + overpressureValue + " max affected radius = " + maxAffectedRadius);

    }
}
