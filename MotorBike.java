public class MotorBike extends Vehicle {

    // Properties
    private String engineSize;

    // Constructor
    public MotorBike(String idPlate, String brand, String model, DateTime entryTime, String engineSize) {
        super(idPlate, brand, model, entryTime);
        this.engineSize = engineSize;
    }

    //	Getters & Setters
    public String getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(String engineSize) {
        this.engineSize = engineSize;
    }

}
