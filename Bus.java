public class Bus extends Vehicle {

    // Properties
    private int seat;
    private double height;

    // Constructor
    public Bus(String idPlate, String brand, String model, DateTime entryTime, int seat, double height) {
        super(idPlate, brand, model, entryTime);
        this.seat = seat;
        this.height = height;
    }

    // Getters & Setters
    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
