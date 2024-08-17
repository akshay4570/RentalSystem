package store;

import location.City;
import reservation.Reservation;
import vehicle.VehicleInventoryMgmt;

import java.util.List;
import java.util.UUID;

public class RentalStore {
    private String storeId;
    private VehicleInventoryMgmt vehicleInventoryMgmt;
    private City city;
    private List<Reservation> listReservation;

    public RentalStore(VehicleInventoryMgmt vehicleInventoryMgmt, City city) {
        this.storeId = UUID.randomUUID().toString();
        this.vehicleInventoryMgmt = vehicleInventoryMgmt;
        this.city = city;
    }

    public String getStoreId() {
        return storeId;
    }

    public VehicleInventoryMgmt getVehicleInventoryMgmt() {
        return vehicleInventoryMgmt;
    }

    public City getCity() {
        return city;
    }

    public List<Reservation> getListReservation() {
        return listReservation;
    }

    public void setListReservation(List<Reservation> listReservation) {
        this.listReservation = listReservation;
    }
}
