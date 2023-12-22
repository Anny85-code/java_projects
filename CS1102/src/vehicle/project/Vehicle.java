package vehicle.project;

/**
 * This interface "Vehicle" includes methods for retrieving the 
 * vehicle's make, model, and year of manufacture.
 */

public interface Vehicle {
    
    String getMake();
    void setMake(String make); // Added setter method for make
    String getModel();
    void setModel(String model); // Added setter method for model
    int getYear();
    void setYear(int year); // Added setter method for year
}

