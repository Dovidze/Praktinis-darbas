package Laboratoriniai;
import java.util.Random;
import java.text.DecimalFormat;

public class GeoLocation {
    private double lat, lon;
    private static int numLocations = 0;


    public static int getNumLocations() {
        return numLocations;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    GeoLocation() {
        Random random = new Random();
        this.lat = Double.parseDouble(new DecimalFormat("#.######").format(-90 + (180 * random.nextDouble())));
        this.lon = Double.parseDouble(new DecimalFormat("#.######").format(-90 + (180 * random.nextDouble())));
        numLocations++;
    }

    GeoLocation(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
        numLocations++;
    }
    public GeoLocation(GeoLocation miestas) {
        Random random = new Random();
        this.lat = Double.parseDouble(new DecimalFormat("#.######").format(miestas.lat +(-0.1 + (0.2 * random.nextDouble()))));
        this.lon = Double.parseDouble(new DecimalFormat("#.######").format(miestas.lon+(-0.1 + (0.2 * random.nextDouble()))));
        numLocations++;
    }
    void print() {
        System.out.println("[" + lat + ", " + lon + "]");
    }
    public static double distance(GeoLocation loc1, GeoLocation loc2) {
        double earthRadius = 6371.0; // Earth radius in kilometers

        double dLat = Math.toRadians(loc2.getLat() - loc1.getLat());
        double dLon = Math.toRadians(loc2.getLon() - loc1.getLon());

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(loc1.getLat())) * Math.cos(Math.toRadians(loc2.getLat())) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

    return Double.parseDouble(new DecimalFormat("#.#").format(earthRadius * c));
    //return earthRadius * c;
    }


    public static void main(String[] args) {

        GeoLocation someLocation = new GeoLocation();
        GeoLocation vilnius = new GeoLocation(54.683333, 25.283333);
        GeoLocation kaunas = new GeoLocation(54.897222, 23.886111);
        GeoLocation nearVilnius = new GeoLocation(vilnius);

        someLocation.print();
        vilnius.print();
        nearVilnius.print();

        System.out.println("Number of locations: " + GeoLocation.getNumLocations());
        System.out.println("From Vilnius to Kaunas: " + GeoLocation.distance(vilnius, kaunas));
        System.out.println("From Vilnius to random location: " + GeoLocation.distance(vilnius, someLocation));
        System.out.println("From Vilnius to random neighbour: " + GeoLocation.distance(vilnius, nearVilnius));

    }
}
