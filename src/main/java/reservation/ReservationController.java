package reservation;

import user.User;
import vehicle.Vehicle;

import java.util.Date;
import java.util.UUID;

public class ReservationController {
    public Reservation createReservation(Vehicle vehicle, User user, Date datePickUp){
        return new Reservation(
                vehicle,
                user,
                new Date(),
                datePickUp
        );
    }
}
