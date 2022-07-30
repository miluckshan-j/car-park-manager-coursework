public class PettahCarParkManagerSimulation {
    public static void main(String[] args) {
        PettahCarParkManager pettahCarParkManager = new PettahCarParkManager();
        int GROUND_FLOOR_SPACE = 60;

        Runnable groundFloorEntry1 = new GroundFloorEntry(pettahCarParkManager, GROUND_FLOOR_SPACE);
        Runnable groundFloorEntry2 = new GroundFloorEntry(pettahCarParkManager, GROUND_FLOOR_SPACE);

        Runnable groundFloorExit1 = new GroundFloorExit(pettahCarParkManager, GROUND_FLOOR_SPACE);
        Runnable groundFloorExit2 = new GroundFloorExit(pettahCarParkManager, GROUND_FLOOR_SPACE);

        Thread northernEntry1 = new Thread(groundFloorEntry1, "NorthernEntry1");
        northernEntry1.setPriority(Thread.MAX_PRIORITY);
        Thread northernEntry2 = new Thread(groundFloorEntry2, "NorthernEntry2");
        northernEntry2.setPriority(Thread.MAX_PRIORITY);

        Thread southernExit1 = new Thread(groundFloorExit1, "SouthernExit1");
        Thread southernExit2 = new Thread(groundFloorExit2, "SouthernExit2");

        northernEntry1.start();
        northernEntry2.start();
        southernExit1.start();
        southernExit2.start();

    }
}
