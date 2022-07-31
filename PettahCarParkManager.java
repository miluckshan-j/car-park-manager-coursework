import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;

public class PettahCarParkManager implements CarParkManager {

    // Properties
    private static PettahCarParkManager instance = null;
    private final ArrayList<Vehicle> listOfVehicle = new ArrayList<Vehicle>();

    // Charging
    private final double chargePerHour = 50;
    private final double addCharge = 75;
    private final double maxCharge = 1200;
    private final int addFromthisHour = 3;

    // Parking Specifics
    private final int carParkCapacity = 60; // Assuming only ground floor
    private int availableSlots = carParkCapacity;

    // Space Allocations
    private final int SPACE_FOR_CAR = 1;
    private final int SPACE_FOR_VAN = 2;
    private final int SPACE_FOR_MOTOR_BIKE = 1; // TODO: Assuming 1 per slot. Change to 3 per slot
    private final int SPACE_FOR_LORRY = 5;
    private final int SPACE_FOR_MINI_LORRY = 3;
    private final int SPACE_FOR_BUS = 5;
    private final int SPACE_FOR_MINI_BUS = 3;

    // Constructor
    public PettahCarParkManager() {
    }

    // Getters & Setters
    public ArrayList<Vehicle> getListOfVehicle() {
        return listOfVehicle;
    }

    // Method which returns an object of same type
    public static PettahCarParkManager getInstance() {
        if (instance == null) {
            synchronized (PettahCarParkManager.class) {
                if (instance == null) {
                    instance = new PettahCarParkManager();
                }
            }
        }
        return instance;
    }

    @Override
    public synchronized void addVehicle(Vehicle obj) {
        // Check whether the vehicle is already parked or not
        for (Vehicle item : listOfVehicle) {
            if (item.equals(obj)) {
                System.out.println("This vehicle is already parked.");
                return;
            }
        }
        // Check whether there are sufficient space available for any vehicle to park
        if (listOfVehicle.size() < carParkCapacity) {
            if (obj instanceof Car) {
                while (availableSlots < SPACE_FOR_CAR) {
                    try {
                        System.out.println("Sorry... There are no slots available to park your Car - " + obj.getIdPlate() + ". Please Standby.");
                        wait(5000);
                    } catch (Exception e) {
                        System.out.println("Error: " + e);
                    }
                }
                listOfVehicle.add(obj);
                availableSlots -= SPACE_FOR_CAR;
                System.out.println("Car " + obj.getIdPlate() + " is parked. \n");
                System.out.println("Available slots : " + availableSlots + "\n");
                notifyAll();
            }
            if (obj instanceof Van) {
                while (availableSlots < SPACE_FOR_CAR) {
                    try {
                        System.out.println("Sorry... There are no slots available to park your Van - " + obj.getIdPlate() + "Please Standby." + "\n");
                        wait(5000);
                    } catch (Exception e) {
                        System.out.println("Error: " + e);
                    }
                }
                listOfVehicle.add(obj);
                availableSlots -= SPACE_FOR_VAN;
                System.out.println("Van " + obj.getIdPlate() + " is parked. \n");
                System.out.println("Available slots : " + availableSlots + "\n");
                notifyAll();
            }
            if (obj instanceof MotorBike) {
                while (availableSlots < SPACE_FOR_CAR) {
                    try {
                        System.out.println("Sorry... There are no slots available to park your Motor Bike - " + obj.getIdPlate() + "Please Standby." + "\n");
                        wait(5000);
                    } catch (Exception e) {
                        System.out.println("Error: " + e);
                    }
                }
                listOfVehicle.add(obj);
                availableSlots -= SPACE_FOR_MOTOR_BIKE;
                System.out.println("Motor Bike " + obj.getIdPlate() + " is parked. \n");
                System.out.println("Available slots : " + availableSlots + "\n");
                notifyAll();
            }
            if (obj instanceof Lorry) {
                while (availableSlots < SPACE_FOR_CAR) {
                    try {
                        System.out.println("Sorry... There are no slots available to park your Lorry - " + obj.getIdPlate() + "Please Standby." + "\n");
                        wait(5000);
                    } catch (Exception e) {
                        System.out.println("Error: " + e);
                    }
                }
                listOfVehicle.add(obj);
                availableSlots -= SPACE_FOR_LORRY;
                System.out.println("Lorry " + obj.getIdPlate() + " is parked. \n");
                System.out.println("Available slots : " + availableSlots + "\n");
                notifyAll();
            }
            if (obj instanceof MiniLorry) {
                while (availableSlots < SPACE_FOR_CAR) {
                    try {
                        System.out.println("Sorry... There are no slots available to park your Mini Lorry - " + obj.getIdPlate() + "Please Standby." + "\n");
                        wait(5000);
                    } catch (Exception e) {
                        System.out.println("Error: " + e);
                    }
                }
                listOfVehicle.add(obj);
                availableSlots -= SPACE_FOR_MINI_LORRY;
                System.out.println("Mini Lorry " + obj.getIdPlate() + " is parked. \n");
                System.out.println("Available slots : " + availableSlots + "\n");
                notifyAll();
            }
            if (obj instanceof Bus) {
                while (availableSlots < SPACE_FOR_CAR) {
                    try {
                        System.out.println("Sorry... There are no slots available to park your Bus - " + obj.getIdPlate() + "Please Standby." + "\n");
                        wait(5000);
                    } catch (Exception e) {
                        System.out.println("Error: " + e);
                    }
                }
                listOfVehicle.add(obj);
                availableSlots -= SPACE_FOR_BUS;
                System.out.println("Bus " + obj.getIdPlate() + " is parked. \n");
                System.out.println("Available slots : " + availableSlots + "\n");
                notifyAll();
            }
            if (obj instanceof MiniBus) {
                while (availableSlots < SPACE_FOR_CAR) {
                    try {
                        System.out.println("Sorry... There are no slots available to park your Mini Bus - " + obj.getIdPlate() + "Please Standby." + "\n");
                        wait(5000);
                    } catch (Exception e) {
                        System.out.println("Error: " + e);
                    }
                }
                listOfVehicle.add(obj);
                availableSlots -= SPACE_FOR_MINI_BUS;
                System.out.println("Mini Bus " + obj.getIdPlate() + " is parked. \n");
                System.out.println("Available slots : " + availableSlots + "\n");
                notifyAll();
            }
        } else {
            System.out.println("Sorry... There are no space available for parking...");
        }
    }

    @Override
    public synchronized void deleteVehicle(String IdPlate) {
        while (listOfVehicle.size() <= 0) {
            try {
                wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (Vehicle item : listOfVehicle) {
            // Checking for a particular vehicle with its plate ID
            if (item.getIdPlate().equals(IdPlate)) {
                System.out.println("Vehicle Found.");
                if (item instanceof Car) {
                    availableSlots += SPACE_FOR_CAR;
                    System.out.println("Space cleared after deleting a Car.\nAvailable Slots : " + availableSlots);
                } else if (item instanceof Van) {
                    availableSlots += SPACE_FOR_VAN;
                    System.out.println("Space cleared after deleting a Van.\nAvailable Slots : " + availableSlots);
                } else if (item instanceof MotorBike) {
                    availableSlots += SPACE_FOR_MOTOR_BIKE;
                    System.out.println("Space cleared after deleting a Motor Bike.\nAvailable Slots : " + availableSlots);
                } else if (item instanceof Lorry) {
                    availableSlots += SPACE_FOR_LORRY;
                    System.out.println("Space cleared after deleting a Lorry.\nAvailable Slots : " + availableSlots);
                } else if (item instanceof MiniLorry) {
                    availableSlots += SPACE_FOR_MINI_LORRY;
                    System.out.println("Space cleared after deleting a Mini Lorry.\nAvailable Slots : " + availableSlots);
                } else if (item instanceof Bus) {
                    availableSlots += SPACE_FOR_BUS;
                    System.out.println("Space cleared after deleting a Bus.\nAvailable Slots : " + availableSlots);
                } else {
                    availableSlots += SPACE_FOR_MINI_BUS;
                    System.out.println("Space cleared after deleting a Mini Bus.\nAvailable Slots : " + availableSlots);
                }
            } else {
                System.out.println("Vehicle not found.");
            }
        }
    }

    @Override
    public void printcurrentVehicles() {
        Collections.sort(listOfVehicle, Collections.reverseOrder());
        for (Vehicle item : listOfVehicle) {
            if (item instanceof Car) {
                System.out.println("Vehicle Type is a Car.");
            } else if (item instanceof Van) {
                System.out.println("Vehicle Type is a Van");
            } else if (item instanceof MotorBike) {
                System.out.println("Vehicle Type is a Motor Bike");
            } else if (item instanceof Lorry) {
                System.out.println("Vehicle Type is a Lorry");
            } else if (item instanceof MiniLorry) {
                System.out.println("Vehicle Type is a Mini Lorry");
            } else if (item instanceof Bus) {
                System.out.println("Vehicle Type is a Bus");
            } else {
                System.out.println("Vehicle Type is a Mini Bus");
            }
            System.out.println("******************");
            System.out.println("ID Plate : " + item.getIdPlate());
            System.out.println("Entry Time : " + item.getEntryDate().getHours() + ":" + item.getEntryDate().getMinutes() + ":" + item.getEntryDate().getSeconds() + "-" + item.getEntryDate().getDate() + "/" + item.getEntryDate().getMonth() + "/" + item.getEntryDate().getYear());
            System.out.println("\n");
        }
    }

    @Override
    public void printLongestPark() {
        // Sort to the ascending order
        Collections.sort(listOfVehicle);
        System.out.println("The longest parked vehicle is : ");
        System.out.println("................................................");
        System.out.println("ID Plate : " + listOfVehicle.get(0).getIdPlate());
        if (listOfVehicle.get(0) instanceof Car) {
            System.out.println("Vehicle Type is a Car.");
        } else if (listOfVehicle.get(0) instanceof Van) {
            System.out.println("Vehicle Type is a Van");
        } else if (listOfVehicle.get(0) instanceof MotorBike) {
            System.out.println("Vehicle Type is a Motor Bike");
        } else if (listOfVehicle.get(0) instanceof Lorry) {
            System.out.println("Vehicle Type is a Lorry");
        } else if (listOfVehicle.get(0) instanceof MiniLorry) {
            System.out.println("Vehicle Type is a Mini Lorry");
        } else if (listOfVehicle.get(0) instanceof Bus) {
            System.out.println("Vehicle Type is a Bus");
        } else {
            System.out.println("Vehicle Type is a Mini Bus");
        }
        System.out.println("Parked Time : " + listOfVehicle.get(0).getEntryDate().getHours() + ":" + listOfVehicle.get(0).getEntryDate().getMinutes() + ":" + listOfVehicle.get(0).getEntryDate().getSeconds());
        System.out.println("Parked Date  : " + listOfVehicle.get(0).getEntryDate().getDate() + "/" + listOfVehicle.get(0).getEntryDate().getMonth() + "/" + listOfVehicle.get(0).getEntryDate().getYear());
    }

    @Override
    public void printLatestPark() {
        // Sort to the descending order
        Collections.sort(listOfVehicle, Collections.reverseOrder());
        System.out.println("The latest parked vehicle is : ");
        System.out.println("..............................................");
        System.out.println("ID Plate : " + listOfVehicle.get(0).getIdPlate());
        if (listOfVehicle.get(0) instanceof Car) {
            System.out.println("Vehicle Type is a Car.");
        } else if (listOfVehicle.get(0) instanceof Van) {
            System.out.println("Vehicle Type is a Van");
        } else if (listOfVehicle.get(0) instanceof MotorBike) {
            System.out.println("Vehicle Type is a Motor Bike");
        } else if (listOfVehicle.get(0) instanceof Lorry) {
            System.out.println("Vehicle Type is a Lorry");
        } else if (listOfVehicle.get(0) instanceof MiniLorry) {
            System.out.println("Vehicle Type is a Mini Lorry");
        } else if (listOfVehicle.get(0) instanceof Bus) {
            System.out.println("Vehicle Type is a Bus");
        } else {
            System.out.println("Vehicle Type is a Mini Bus");
        }
        System.out.println("Parked Time : " + listOfVehicle.get(0).getEntryDate().getHours() + ":" + listOfVehicle.get(0).getEntryDate().getMinutes() + ":" + listOfVehicle.get(0).getEntryDate().getSeconds());
        System.out.println("Parked Date  : " + listOfVehicle.get(0).getEntryDate().getDate() + "/" + listOfVehicle.get(0).getEntryDate().getMonth() + "/" + listOfVehicle.get(0).getEntryDate().getYear());
    }

    @Override
    public void printVehicleByDay(DateTime givenDate) {
        for (Vehicle item : listOfVehicle) {
            if (givenDate.getYear() == item.getEntryDate().getYear() && givenDate.getMonth() == item.getEntryDate().getMonth() && givenDate.getDate() == item.getEntryDate().getDate()) {
                System.out.println("ID Plate : " + item.getIdPlate());
                System.out.println("Parked Date and Time : " + item.getEntryDate().getDate() + "/" + item.getEntryDate().getMonth() + "/" + item.getEntryDate().getHours() + "-" + item.getEntryDate().getHours() + ":" + item.getEntryDate().getMinutes() + ":" + item.getEntryDate().getYear());
                if (item instanceof Car) {
                    System.out.println("Vehicle Type is a Car.");
                } else if (item instanceof Van) {
                    System.out.println("Vehicle Type is a Van");
                } else if (item instanceof MotorBike) {
                    System.out.println("Vehicle Type is a Motor Bike");
                } else if (item instanceof Lorry) {
                    System.out.println("Vehicle Type is a Lorry");
                } else if (item instanceof MiniLorry) {
                    System.out.println("Vehicle Type is a Mini Lorry");
                } else if (item instanceof Bus) {
                    System.out.println("Vehicle Type is a Bus");
                } else {
                    System.out.println("Vehicle Type is a Mini Bus");
                }
                System.out.println("--------------------------");
                System.out.println("\n");
            }
        }
    }

    @Override
    public void printVehiclePercentage() {
        int numCars = 0;
        int numVans = 0;
        int numBikes = 0;
        int numLorry = 0;
        int numMiniLorry = 0;
        int numBus = 0;
        int numMiniBus = 0;
        for (Vehicle item : listOfVehicle) {
            if (item instanceof Car) {
                numCars++;
            } else if (item instanceof Van) {
                numVans++;
            } else if (item instanceof MotorBike) {
                numBikes++;
            } else if (item instanceof Lorry) {
                numLorry++;
            } else if (item instanceof MiniLorry) {
                numMiniLorry++;
            } else if (item instanceof Bus) {
                numBus++;
            } else {
                numMiniBus++;
            }
        }
        double carPercentage = (numCars / listOfVehicle.size()) * 100;
        double vanPercentage = (numVans / listOfVehicle.size()) * 100;
        double bikePercentage = (numBikes / listOfVehicle.size()) * 100;
        double lorryPercentage = (numLorry / listOfVehicle.size()) * 100;
        double miniLorryPercentage = (numMiniLorry / listOfVehicle.size()) * 100;
        double busPercentage = (numBus / listOfVehicle.size()) * 100;
        double miniBusPercentage = (numMiniBus / listOfVehicle.size()) * 100;
        System.out.printf("Car percentage is : %.f \n", carPercentage);
        System.out.printf("Van percentage is : %.f \n", vanPercentage);
        System.out.printf("Motor Bike percentage is : %.f \n", bikePercentage);
        System.out.printf("Lorry percentage is : %.f \n", lorryPercentage);
        System.out.printf("Mini Lorry percentage is : %.f \n", miniLorryPercentage);
        System.out.printf("Bus percentage is : %.f \n", busPercentage);
        System.out.printf("Mini Bus percentage is : %.f \n", miniBusPercentage);
        System.out.println("\n");
    }

    @Override
    public BigDecimal calculateChargers(String plateID, DateTime currentTime) {
        boolean found = false;
        BigDecimal charges = null;
        for (Vehicle item : listOfVehicle) {
            if (item.getIdPlate().equals(plateID)) {
                System.out.println("Vehicle found.");
                // Vehicle parked time
                System.out.println("Parked time : " + item.getEntryDate().getDate() + "/" + item.getEntryDate().getMonth() + "/" + item.getEntryDate().getDate() + "-" + item.getEntryDate().getHours() + ":" + item.getEntryDate().getMinutes() + ":" + item.getEntryDate().getSeconds());
                // Making the charges
                found = true;
                DateTime entryDateTime = item.getEntryDate();
                int differenceInSeconds = currentTime.compareTo(entryDateTime);
                double differenceInHours = differenceInSeconds / (60.0 * 60.0);
                double dayCharge = 0;
                double hourCharge = 0;
                double totalCost = 0;
                double days = differenceInHours / 24;
                if (days > 1) {
                    dayCharge = maxCharge;
                }
                if (differenceInHours >= 3) {
                    double additional = (differenceInHours - addFromthisHour);
                    hourCharge = (additional * addCharge) + (addFromthisHour * chargePerHour);
                    System.out.printf("Hour charge : %.2f", hourCharge);
                } else if (differenceInHours < 1) {
                    hourCharge = chargePerHour;
                } else {
                    hourCharge = (differenceInHours * chargePerHour);
                }
                totalCost = dayCharge + hourCharge;
                BigDecimal vehicleCharge = new BigDecimal(totalCost);
                System.out.printf("Total charge for the vehicle is LKR %.2f", vehicleCharge);
                System.out.println("\n");
            }
        }
        if (!found) {
            System.out.println("Vehicle not found\n");
        }
        return charges;
    }
}
