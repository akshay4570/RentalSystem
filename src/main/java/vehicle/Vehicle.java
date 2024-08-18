package vehicle;

import rental.RentalDetails;
import rental.RentalFactory;

public abstract class Vehicle {
    private VehicleRegistrationDetails vehicleRegistrationDetails;
    private VehicleSpecs vehicleSpecs;
    private RentalDetails rentalDetails;
    private Status status;

    public Vehicle(VehicleRegistrationDetails vehicleRegistrationDetails, VehicleSpecs vehicleSpecs, Status status) {
        this.vehicleRegistrationDetails = vehicleRegistrationDetails;
        this.vehicleSpecs = vehicleSpecs;
        this.rentalDetails = RentalFactory.getRentalDetails(this);
        this.status = status;
    }

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
