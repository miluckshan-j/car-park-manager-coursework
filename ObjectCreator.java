import java.awt.*;
import java.util.Scanner;

public class ObjectCreator {

    public Vehicle createVehicle(VehicleType type) {
        Vehicle obj = null;

        Scanner sc = new Scanner(System.in); // Question
        System.out.println("Enter Plate ID :");
        String plateID = sc.next();
        System.out.println("Enter the Brand :");
        String brand = sc.next();
        System.out.println("Enter the Model :");
        String model = sc.next();
        System.out.println("Enter the date and time (DD/MM/YYYY-HH:mm:ss)");
        String dateTime = sc.next();

        // Adding the data in to a string array
        String[] arr = dateTime.split("-");
        String[] dateString = arr[0].split("/");
        String[] timeString = arr[1].split(":");
        DateTime entryTime = new DateTime(Integer.parseInt(dateString[0]), Integer.parseInt(dateString[1]), Integer.parseInt(dateString[2]), Integer.parseInt(timeString[0]), Integer.parseInt(timeString[1]), Integer.parseInt(timeString[2]));

        switch (type) {
            case Car:
                System.out.println("Enter number of Doors : ");
                int numDoors = sc.nextInt();
                System.out.println("Enter the Color of the Car (R/G/B) : ");
                String colorString = sc.next();
                String[] colorArr = colorString.split("/");
                Color carColor = new Color(Integer.parseInt(colorArr[0]), Integer.parseInt(colorArr[1]), Integer.parseInt(colorArr[2]));
                obj = new Car(plateID, brand, model, entryTime, numDoors, carColor);
                break;
            case Van:
                System.out.println("Enter the number of seats : ");
                int seats = sc.nextInt();
                obj = new Van(plateID, brand, model, entryTime, seats);
                break;
            case MotorBike:
                System.out.println("Enter the Engine Size : ");
                String engineSize = sc.next();
                obj = new MotorBike(plateID, brand, model, entryTime, engineSize);
                break;
            case Lorry:
                System.out.println("Enter the Cargo Capacity : ");
                double lorryCargoCapacity = sc.nextDouble();
                System.out.println("Enter the height : ");
                double lorryHeight = sc.nextDouble();
                new Lorry(plateID, brand, model, entryTime, lorryCargoCapacity, lorryHeight);
            case MiniLorry:
                System.out.println("Enter the Cargo Capacity : ");
                double miniLorryCargoCapacity = sc.nextDouble();
                System.out.println("Enter the height : ");
                double miniLorryHeight = sc.nextDouble();
                new Lorry(plateID, brand, model, entryTime, miniLorryCargoCapacity, miniLorryHeight);
            case MiniBus:
                System.out.println("Enter the number of seats : ");
                int miniBusSeats = sc.nextInt();
                System.out.println("Enter the height : ");
                double miniBusHeight = sc.nextDouble();
                new MiniBus(plateID, brand, model, entryTime, miniBusSeats, miniBusHeight);
            default:
                System.out.println("Invalid Choice");
        }
        return obj;
    }

}


