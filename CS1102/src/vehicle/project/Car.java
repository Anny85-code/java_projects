package vehicle.project;

/** 
 * A class named "Car" that implements the Vehicle and "CarVehicle" interfaces.
 */

class Car implements Vehicle, CarVehicle {
    private String make;
    private String model;
    private int year;
    private int numDoors;
    private String fuelType;

    // Implement getMethods from the Vehicle interface
    @Override
    public String getMake() {
        return make;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getYear() {
        return year;
    }

    // Implement getMethods from the CarVehicle interface
    @Override
    public int getNumDoors() {
        return numDoors;
    }

    @Override
    public String getFuelType() {
        return fuelType;
    }

    //Implement setMethods from the CarVehicle interface
    @Override
    public void setNumDoors(int doors) {
        this.numDoors = doors;
    }

    @Override
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
    
    @Override
    public void setMake(String make) {
        this.make = make;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public void setYear(int year) {
        this.year = year;
    }
}
