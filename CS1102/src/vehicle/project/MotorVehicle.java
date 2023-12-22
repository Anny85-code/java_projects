package vehicle.project;

/**
 * MotorVehicle interfaces. This interface have methods for setting 
 * and retrieving the number of wheels and the 
 * type of motorcycle (sport, cruiser, or off-road).
 */

public interface MotorVehicle {
    int getNumWheels();
    String getMotorcycleType();
    void setNumWheels(int wheels);
    void setMotorcycleType(String type);
}
