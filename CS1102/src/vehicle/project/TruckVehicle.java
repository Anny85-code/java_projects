package vehicle.project;

/**
 * This interface include methods for setting 
 * and retrieving the cargo capacity (in tons) 
 * and the transmission type (manual or automatic).
 */

public interface TruckVehicle {
    double getCargoCapacity();
    String getTransmissionType();
    void setCargoCapacity(double capacity);
    void setTransmissionType(String transmissionType);
}
