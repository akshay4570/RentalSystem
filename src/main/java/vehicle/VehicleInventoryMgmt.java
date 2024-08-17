package vehicle;

import dao.VehicleDAO;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class VehicleInventoryMgmt {
    private List<Vehicle> listVehicle;
    private VehicleDAO vehicleDAO;

    public VehicleInventoryMgmt(VehicleDAO vehicleDAO) throws ExecutionException, InterruptedException {
        this.vehicleDAO = vehicleDAO;
        listVehicle = getVehicles();
    }

    public List<Vehicle> getVehicles() throws ExecutionException, InterruptedException {
        return vehicleDAO.getVehiclesFromDB().get();
    }
    public void addVehicles(List<Vehicle> listVeh){
        vehicleDAO.addVehicleToDB(listVeh);
    }

    public void deleteVehicle(Vehicle vehicle){
        vehicleDAO.removeFromDB(vehicle);
    }
}
