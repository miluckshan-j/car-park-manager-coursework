public class Van extends Vehicle {

    // Properties
    private int seats;

    // Constructor
    public Van(String idPlate, String brand, String model, DateTime entryTime, int seats) {
        super(idPlate, brand, model, entryTime);
        this.seats = seats;
    }

    // Getters & Setters
    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
