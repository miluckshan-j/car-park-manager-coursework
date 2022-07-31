import java.util.Random;

public class GroundFloorExit implements Runnable {
    private final PettahCarParkManager pettahCarParkManager;
    private final int FLOOR_SPACE;

    public GroundFloorExit(PettahCarParkManager pettahCarParkManager, int FLOOR_SPACE) {
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
        while(true){
            if (pettahCarParkManager.getListOfVehicle().size() > 0) {
                try {
                    pettahCarParkManager.deleteVehicle("WP-" + randomNumberGenerator(0, 250));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
