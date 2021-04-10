package parking.partTwo;

import java.util.ArrayList;

public class AutoParking {
    public static volatile ArrayList<Thread> autoParking = new ArrayList<>();

    public static ArrayList<Thread> entry = new ArrayList<>();

    public static ArrayList<Thread> departure = new ArrayList<>();

}
