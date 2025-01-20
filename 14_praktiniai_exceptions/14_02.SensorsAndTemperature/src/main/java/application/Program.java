package application;

public class Program {

    public static void main(String[] args) {
        // you can test your classes here:

        Sensor kumpula = new TemperatureSensor();
        Sensor kaisaniemi = new TemperatureSensor();
        Sensor helsinkiAirport = new TemperatureSensor();

        AverageSensor helsinkiRegion = new AverageSensor();
        helsinkiRegion.addSensor(kumpula);
        helsinkiRegion.addSensor(kaisaniemi);
        helsinkiRegion.addSensor(helsinkiAirport);

        helsinkiRegion.setOn();
        System.out.println("temperature " + helsinkiRegion.read());
        System.out.println("temperature " + helsinkiRegion.read());
        System.out.println("temperature " + helsinkiRegion.read());

        System.out.println("readings " + helsinkiRegion.readings());
        
    }

}
