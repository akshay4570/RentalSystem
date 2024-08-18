package dao;

import vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class VehicleDAO {
    private List<Vehicle> listVehicleInDB;

    public VehicleDAO() {
        this.listVehicleInDB = new ArrayList<>();
    }

    public CompletableFuture<Void> addVehicleToDB(List<Vehicle> listVeh) {
        listVehicleInDB.addAll(listVeh);
        return CompletableFuture.completedFuture(null);
    }

    public CompletableFuture<Void> removeFromDB(Vehicle vehicle) {
        listVehicleInDB.remove(vehicle);
        return CompletableFuture.completedFuture(null);
    }

    public CompletableFuture<List<Vehicle> > getVehiclesFromDB(){
        return CompletableFuture.completedFuture(listVehicleInDB);
    }
}
