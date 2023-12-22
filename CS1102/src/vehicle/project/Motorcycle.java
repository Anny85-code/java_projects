package vehicle.project;

/**
 * A Motorcycle class that implements Vehicle and the "MotorVehicle" interfaces. 
 */

class Motorcycle implements Vehicle, MotorVehicle {
    private String make;
    private String model;
    private int year;
    private int numWheels;
    private String motorcycleType;

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

    // Implement getMethods from the MotorVehicle interface
    @Override
    public int getNumWheels() {
        return numWheels;
    }

    @Override
    public String getMotorcycleType() {
        return motorcycleType;
    }

    @Override
    public void setNumWheels(int wheels) {
        this.numWheels = wheels;
    }

    @Override
    public void setMotorcycleType(String type) {
        this.motorcycleType = type;
    }
    
    // Implement setter methods from the Vehicle interface
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

