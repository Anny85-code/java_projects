package vehicle.project;

import java.util.Scanner;

/**
 * This is the main method of the program, it takes input from the user and 
 * allows the user to create objects of different vehicle types, 
 * provide relevant information, and display the details of each vehicle.

 */

public class VehicleMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to your favorite Vehicle Plug!!");
        // Create objects of different vehicle types
        Car car = createCar(scanner);
        Motorcycle motorcycle = createMotorcycle(scanner);
        Truck truck = createTruck(scanner);

        // Display details of each vehicle
        displayVehicleDetails(car);
        displayVehicleDetails(motorcycle);
        displayVehicleDetails(truck);

        scanner.close();
    }

    private static Car createCar(Scanner scanner) {
        Car car = new Car();
        System.out.println("Please provide these informations to create a car!");
        setVehicleDetails(scanner, car);

        // Get additional details for Car
        car.setNumDoors(getIntInput(scanner, "Enter number of doors: "));
        car.setFuelType(getFuelType(scanner));
        System.out.println("You have successfully created a car!\n");
        return car;
    }

    private static Motorcycle createMotorcycle(Scanner scanner) {
        Motorcycle motorcycle = new Motorcycle();
        System.out.println("Please provide these informations to create a motorcyle!");
        setVehicleDetails(scanner, motorcycle);

        // Get additional details for Motorcycle
        motorcycle.setNumWheels(getIntInput(scanner, "Enter number of wheels: "));
        motorcycle.setMotorcycleType(getMotorcycleType(scanner));
        System.out.println("You have successfully created a motorcycle!\n");
        return motorcycle;
    }

    private static Truck createTruck(Scanner scanner) {
        Truck truck = new Truck();
        System.out.println("Please provide these informations to create a truck!");
        setVehicleDetails(scanner, truck);

        // Get additional details for Truck
        truck.setCargoCapacity(getDoubleInput(scanner, "Enter cargo capacity (in tons): "));
        truck.setTransmissionType(getTransmissionType(scanner));
        System.out.println("You have successfully created a truck!\n");
        return truck;
    }

    private static void setVehicleDetails(Scanner scanner, Vehicle vehicle) {
        System.out.print("Enter make: ");
        String make = scanner.next();
        vehicle.setMake(make);

        System.out.print("Enter model: ");
        String model = scanner.next();
        vehicle.setModel(model);

        vehicle.setYear(getIntInput(scanner, "Enter year: "));
    }

    private static int getIntInput(Scanner scanner, String prompt) {
        int input = 0;
        boolean isValid = false;
        while (!isValid) {
            try {
                System.out.print(prompt);
                input = Integer.parseInt(scanner.next());
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        return input;
    }

    private static double getDoubleInput(Scanner scanner, String prompt) {
        double input = 0;
        boolean isValid = false;
        while (!isValid) {
            try {
                System.out.print(prompt);
                input = Double.parseDouble(scanner.next());
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        return input;
    }

    private static String getFuelType(Scanner scanner) {
        String fuelType = "";
        boolean isValid = false;
        while (!isValid) {
            System.out.print("Enter fuel type (Petrol/Diesel/Electric): ");
            fuelType = scanner.next().toLowerCase();
            if (fuelType.equals("petrol") || fuelType.equals("diesel") || fuelType.equals("electric")) {
                isValid = true;
            } else {
                System.out.println("Invalid input. Please enter a valid fuel type.");
            }
        }
        return fuelType;
    }

    private static String getMotorcycleType(Scanner scanner) {
        String motorcycleType = "";
        boolean isValid = false;
        while (!isValid) {
            System.out.print("Enter motorcycle type (Sport/Cruiser/Off-road): ");
            motorcycleType = scanner.next().toLowerCase();
            if (motorcycleType.equals("sport") || motorcycleType.equals("cruiser") || motorcycleType.equals("off-road")) {
                isValid = true;
            } else {
                System.out.println("Invalid input. Please enter a valid motorcycle type.");
            }
        }
        return motorcycleType;
    }

    private static String getTransmissionType(Scanner scanner) {
        String transmissionType = "";
        boolean isValid = false;
        while (!isValid) {
            System.out.print("Enter transmission type (Manual/Automatic): ");
            transmissionType = scanner.next().toLowerCase();
            if (transmissionType.equals("manual") || transmissionType.equals("automatic")) {
                isValid = true;
            } else {
                System.out.println("Invalid input. Please enter a valid transmission type.");
            }
        }
        return transmissionType;
    }

    // Method to display details of a vehicle
    private static void displayVehicleDetails(Vehicle vehicle) {
        System.out.println("\nVehicle Details:");
        System.out.println("Make: " + vehicle.getMake());
        System.out.println("Model: " + vehicle.getModel());
        System.out.println("Year: " + vehicle.getYear());

        if (vehicle instanceof CarVehicle) {
            CarVehicle carVehicle = (CarVehicle) vehicle;
            System.out.println("Number of Doors: " + carVehicle.getNumDoors());
            System.out.println("Fuel Type: " + carVehicle.getFuelType());
        }

        if (vehicle instanceof MotorVehicle) {
            MotorVehicle motorVehicle = (MotorVehicle) vehicle;
            System.out.println("Number of Wheels: " + motorVehicle.getNumWheels());
            System.out.println("Motorcycle Type: " + motorVehicle.getMotorcycleType());
        }

        if (vehicle instanceof TruckVehicle) {
            TruckVehicle truckVehicle = (TruckVehicle) vehicle;
            System.out.println("Cargo Capacity: " + truckVehicle.getCargoCapacity() + " tons");
            System.out.println("Transmission Type: " + truckVehicle.getTransmissionType());
        }
    }
}

