package invoice;

import reservation.Reservation;

import java.util.UUID;

public class Invoice {
    private Reservation reservation;
    private String id;
    private Double amount;

    public Invoice(Reservation reservation, Double amount) {
        this.reservation = reservation;
        this.id = UUID.randomUUID().toString();
        this.amount = amount;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public String getId() {
        return id;
    }

    public Double getAmount() {
        return amount;
    }
}
