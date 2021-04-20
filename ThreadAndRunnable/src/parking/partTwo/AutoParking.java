package parking.partTwo;

public class AutoParking {

    private volatile int places = 0;

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }
}
