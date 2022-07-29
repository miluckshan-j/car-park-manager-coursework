public abstract class Vehicle extends Object implements Comparable<Vehicle> {

    //Vehicle Properties
    private String idPlate;
    private String brand;
    private String model;
    private DateTime entryTime;
    //Constructor
    public Vehicle(String idPlate, String brand, String model, DateTime entryTime) {
        this.idPlate = idPlate;
        this.brand = brand;
        this.model = model;
        this.entryTime = entryTime;
    }

    @Override
    public int compareTo(Vehicle o) {
        return this.entryTime.compareTo(o.entryTime);
    }

    public String getIdPlate() {
        return idPlate;
    }

    public void setIdPlate(String idPlate) {
        this.idPlate = idPlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public DateTime getEntryDate() {
        return entryTime;
    }

    public void setEntryDate(DateTime entryTime) {
        this.entryTime = entryTime;
    }


}
