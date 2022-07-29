import java.util.Scanner;

public class ConsoleApplication {

    private static final PettahCarParkManager pettahCarParkManager = PettahCarParkManager.getInstance();

    public static void main(String[] args) {

        //getting the choice from the input
        while (true) {
            System.out.println("Select your Choice : ");
            System.out.println("1. Add Vehicle");
            System.out.println("2. Delete Vehicle");
            System.out.println("3. Print the current available vehicle");
            System.out.println("4. Print statistics");
            System.out.println("5. Vehicles parked in a day.");
            System.out.println("6. Charge for the parking");
            System.out.println("7. Percentage of vehicles");
            System.out.println("8. Hit '0' to Exit");
            System.out.println(">>>>");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addVehicle();
                    break;
                case 2:
                    deleteVehicle();
                    break;
                case 3:
                    printVehicle();
                    break;
                case 4:
                    printStatistics();
                    break;
                case 5:
                    parkedByDay();
                    break;
                case 6:
                    calCharge();
                    break;
                case 7:
                    vehiclePercentage();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid choice");
            }
        }
    }

    private static void vehiclePercentage() {
        pettahCarParkManager.printVehiclePercentage();
    }

    private static void parkedByDay() {
        //getting Date from the user
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Date to Find (DD/MM/YYYY-HH:mm:ss) : ");
        String checkThisTime = sc.next();
        String[] date = checkThisTime.split("-");
        String[] dateString = date[0].split("/");
        String[] timeString = date[1].split(":");
        DateTime givenDate = new DateTime(Integer.parseInt(dateString[0]), Integer.parseInt(dateString[1]), Integer.parseInt(dateString[2]), Integer.parseInt(timeString[0]), Integer.parseInt(timeString[1]), Integer.parseInt(timeString[2]));
        pettahCarParkManager.printVehicleByDay(givenDate);
    }

    private static void calCharge() {
        // Getting plate ID from the user
        System.out.println("Enter the Plate ID : ");
        Scanner sc = new Scanner(System.in);
        String plateID = sc.next();
        // Getting Date from the user
        System.out.println("Enter the leaving time : (DD/MM/YYYY - HH:mm:ss)");
        String leavingTime = sc.next();
        String[] arr1 = leavingTime.split("-");
        String[] dateString = arr1[0].split("/");
        String[] timeString = arr1[1].split(":");

        DateTime currentTime = new DateTime(Integer.parseInt(dateString[0]), Integer.parseInt(dateString[1]), Integer.parseInt(dateString[2]), Integer.parseInt(timeString[0]), Integer.parseInt(timeString[1]), Integer.parseInt(timeString[2]));
        pettahCarParkManager.calculateChargers(plateID, currentTime);
    }


    private static void printVehicle() {
        pettahCarParkManager.printcurrentVehicles();
    }

    private static void printStatistics() {
        pettahCarParkManager.printLongestPark();
        System.out.println("\n");
        pettahCarParkManager.printLatestPark();
    }

    private static void addVehicle() {
        // Getting choice from the user
        System.out.println("Select your choice : ");
        System.out.println("******************");
        System.out.println("1. To add a Car.");
        System.out.println("2. To add a Motor Bike.");
        System.out.println("3. To add a Van.");
        System.out.println("4. To add a Lorry.");
        System.out.println("5. To add a Mini Lorry.");
        System.out.println("6. To add a Mini Bus.");
        System.out.println(">>>>");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        // TODO: Use switch case
        VehicleType type = (choice == 1) ? VehicleType.Car : (choice == 2) ? VehicleType.MotorBike : (choice == 3) ? VehicleType.Van : (choice == 4) ? VehicleType.Lorry : (choice == 5) ? VehicleType.MiniLorry : (choice == 6) ? VehicleType.MiniBus : null;
        ObjectCreator creator = new ObjectCreator();
        Vehicle vehicle = creator.createVehicle(type);
        pettahCarParkManager.addVehicle(vehicle);
    }

    private static void deleteVehicle() {
        // Getting plate ID from the user
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Plate ID :");
        String plateID = input.next();
        pettahCarParkManager.deleteVehicle(plateID);
    }

}
