import java.awt.*;
import java.util.Random;

public class GroundFloorEntry implements Runnable {
    private final PettahCarParkManager pettahCarParkManager;
    private final int FLOOR_SPACE;

    public GroundFloorEntry(PettahCarParkManager pettahCarParkManager, int FLOOR_SPACE) {
        super();
        this.pettahCarParkManager = pettahCarParkManager;
        this.FLOOR_SPACE = FLOOR_SPACE;
    }

    private static int randomNumberGenerator(int origin, int bound) {
        Random r = new Random();
        return r.nextInt(origin, bound);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Vehicle vehicle;
                double randomNumber = Math.random();
                DateTime entry = new DateTime(2021, randomNumberGenerator(1, 12), randomNumberGenerator(1, 28), randomNumberGenerator(00, 23), randomNumberGenerator(00, 60), randomNumberGenerator(00, 60));
                if (randomNumber < 0.142) {
                    // Car
                    vehicle = new Car("WP-" + randomNumberGenerator(0, 250), "Nissan", "Leaf", entry, 4, Color.WHITE);
                } else if (randomNumber < 0.285) {
                    // Van
                    vehicle = new Van("WP-" + randomNumberGenerator(0, 250), "Toyota", "Hiace", entry, 8);
                } else if (randomNumber < 0.428) {
                    // Motor Bike
                    vehicle = new MotorBike("WP-" + randomNumberGenerator(0, 250), "TVS", "Platina", entry, "1500CC");
                } else if (randomNumber < 0.571) {
                    // Lorry
                    vehicle = new Lorry("WP-" + randomNumberGenerator(0, 250), "Mitsubishi", "Canter", entry, 1000.0, 5.5);
                } else if (randomNumber < 0.714) {
                    // Mini Lorry
                    vehicle = new MiniLorry("WP-" + randomNumberGenerator(0, 250), "Dimo", "Batta", entry, 500.0, 4.0);
                } else if (randomNumber < 0.857) {
                    // Bus
                    vehicle = new Bus("WP-" + randomNumberGenerator(0, 250), "Tata", "Leyland", entry, 55, 4.0);
                } else {
                    // Mini Bus
                    vehicle = new MiniBus("WP-" + randomNumberGenerator(0, 250), "Toyota", "Coaster", entry, 30, 3.0);
                }
                pettahCarParkManager.addVehicle(vehicle);

            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
