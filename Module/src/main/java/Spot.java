
public record Spot(String name, double latitude, double longitude) implements Comparable <Spot> {

    public static Spot randomSpot() {
        String name = "";

        // Generate four random uppercase letters
        for (int i = 0; i < 4; i++) {
            char letter = (char) ('A' + (int) (Math.random() * 26));
            name += letter;
        }

        // Generate a longitude between -180 and 180
        double longitude = Math.random() * 360 - 180;

        // Generate a number between -1 and 1
        double randomNumber = Math.random() * 2 - 1;

        // Find the inverse sine and convert from radians to degrees
        double latitude = Math.toDegrees(Math.asin(randomNumber));

        return new Spot(name, latitude, longitude);
    }


    public int compareTo(Spot other) {
        if (this.longitude < other.longitude) {
            return -1;
        } else if (this.longitude > other.longitude) {
            return 1;
        } else {
            return 0;
        }
    }


}

