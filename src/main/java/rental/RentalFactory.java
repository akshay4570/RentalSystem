package rental;

import vehicle.Bike;
import vehicle.Car;
import vehicle.Vehicle;

public class RentalFactory {

    public static RentalDetails getRentalDetails(Vehicle vehicle){
        RentalDetails rentalDetails;
        if(vehicle instanceof Car){
            return new RentalDetails(2000, 20);
        }else if (vehicle instanceof Bike){
            return new RentalDetails(1000, 10);
        }
        return new RentalDetails(5000, 50);
    }
}
