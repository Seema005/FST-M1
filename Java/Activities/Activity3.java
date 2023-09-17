package Activities;

public class Activity3 {
    public static void main(String[] args) {
        double seconds = 1000000000.0;

        double EarthSeconds = 31557600.0;
        double MercurySeconds = 0.2408467 * EarthSeconds;
        double VenusSeconds = 0.61519726 * EarthSeconds;
        double MarsSeconds = 1.8808158 * EarthSeconds;
        double JupiterSeconds = 11.862615 * EarthSeconds;
        double SaturnSeconds = 29.447498 * EarthSeconds;
        double UranusSeconds = 84.016846 * EarthSeconds;
        double NeptuneSeconds = 164.79132 * EarthSeconds;

        double ageOnEarth = seconds / EarthSeconds;
        double ageOnMercury = seconds / MercurySeconds;
        double ageOnVenus = seconds / VenusSeconds;
        double ageOnMars = seconds / MarsSeconds;
        double ageOnJupiter = seconds / JupiterSeconds;
        double ageOnSaturn = seconds / SaturnSeconds;
        double ageOnUranus = seconds / UranusSeconds;
        double ageOnNeptune = seconds / NeptuneSeconds;

        System.out.println("Age on Earth: " + ageOnEarth + " Earth-years");
        System.out.println("Age on Mercury: " + ageOnMercury + " Mercury-years");
        System.out.println("Age on Venus: " + ageOnVenus + " Venus-years");
        System.out.println("Age on Mars: " + ageOnMars + " Mars-years");
        System.out.println("Age on Jupiter: " + ageOnJupiter + " Jupiter-years");
        System.out.println("Age on Saturn: " + ageOnSaturn + " Saturn-years");
        System.out.println("Age on Uranus: " + ageOnUranus + " Uranus-years");
        System.out.println("Age on Neptune: " + ageOnNeptune + " Neptune-years");
    }
}

