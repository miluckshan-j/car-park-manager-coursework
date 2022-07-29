public class MiniLorry extends Vehicle {

    // Properties
    private double cargoVolume;
    private double height;

    // Constructor
    public MiniLorry(String idPlate, String brand, String model, DateTime entryTime, double cargoVolume, double height) {
        super(idPlate, brand, model, entryTime);
        this.cargoVolume = cargoVolume;
        this.height = height;
    }

    // Getters & Setters
    public double getCargoVolume() {
        return cargoVolume;
    }

    public void setCargoVolume(double cargoVolume) {
        this.cargoVolume = cargoVolume;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
