package reservation;

import store.RentalStore;
import user.User;
import vehicle.Vehicle;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ReservationController {

    public static synchronized Reservation createReservation(Vehicle vehicle, User user, RentalStore rentalStore, Date dateReserved, Date datePickUp, Date dateReturn) throws ExecutionException, InterruptedException {
        boolean isPresent = rentalStore.getVehicleInventoryMgmt().getVehicles().contains(vehicle);
        Reservation reservation = null;
        if(isPresent){
            reservation = new Reservation(
                    vehicle, user, dateReserved, datePickUp, dateReturn
            );
            rentalStore.getVehicleInventoryMgmt().deleteVehicle(vehicle);
        }
        return reservation;
    }

    public static void completeReservation(Vehicle vehicle, RentalStore rentalStore){
        //Update some metadata
        rentalStore.getVehicleInventoryMgmt().addVehicles(List.of(vehicle));
    }
}
