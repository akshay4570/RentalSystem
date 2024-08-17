package vehicle;

public abstract class Vehicle {
    private VehicleRegistrationDetails vehicleRegistrationDetails;
    private VehicleSpecs vehicleSpecs;
    private RentalDetails rentalDetails;
    private Status status;

    public VehicleRegistrationDetails getVehicleRegistrationDetails() {
        return vehicleRegistrationDetails;
    }

    public void setVehicleRegistrationDetails(VehicleRegistrationDetails vehicleRegistrationDetails) {
        this.vehicleRegistrationDetails = vehicleRegistrationDetails;
    }

    public VehicleSpecs getVehicleSpecs() {
        return vehicleSpecs;
    }

    public void setVehicleSpecs(VehicleSpecs vehicleSpecs) {
        this.vehicleSpecs = vehicleSpecs;
    }

    public RentalDetails getRentalDetails() {
        return rentalDetails;
    }

    public void setRentalDetails(RentalDetails rentalDetails) {
        this.rentalDetails = rentalDetails;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
