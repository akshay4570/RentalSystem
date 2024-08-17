package reservation;

import user.User;
import vehicle.Vehicle;

import java.util.Date;
import java.util.UUID;

public class Reservation {

    private String id;
    private Vehicle vehicle;
    private User user;
    private Date dateReserved;
    private Date datePickUp;
    private Date dateReturned;
    private ReservationStatus reservationStatus;

    public Reservation(Vehicle vehicle, User user, Date dateReserved, Date datePickUp) {
        this.id = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.user = user;
        this.dateReserved = dateReserved;
        this.datePickUp = datePickUp;
    }

    public String getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public User getUser() {
        return user;
    }

    public Date getDateReserved() {
        return dateReserved;
    }

    public Date getDatePickUp() {
        return datePickUp;
    }

    public Date getDateReturned() {
        return dateReturned;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDateReturned(Date dateReturned) {
        this.dateReturned = dateReturned;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }
}
