package vehicle.project;

/**
 * CarVehicle interfaces with additional methods for setting 
 * and retrieving the number of doors and the fuel type (petrol, diesel, or electric).
 */

public interface CarVehicle {
    int getNumDoors();
    String getFuelType();
    void setNumDoors(int doors);
    void setFuelType(String fuelType);
}
