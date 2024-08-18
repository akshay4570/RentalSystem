package vehicle;

import rental.RentalDetails;

public class Car extends Vehicle{
    public Car(VehicleRegistrationDetails vehicleRegistrationDetails, VehicleSpecs vehicleSpecs, Status status) {
        super(vehicleRegistrationDetails, vehicleSpecs, status);
    }
}
