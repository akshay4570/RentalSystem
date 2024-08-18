import dao.VehicleDAO;
import data.DataSetup;
import invoice.Invoice;
import location.City;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import payment.Payment;
import payment.UPIPayment;
import reservation.Reservation;
import reservation.ReservationController;
import store.RentalStore;
import user.User;
import vehicle.Vehicle;
import vehicle.VehicleInventoryMgmt;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestRentalSystem {

    private List<User> listUser;
    private List<Vehicle> listVehicle;
    private List<City> listCities;
    private List<VehicleInventoryMgmt> listVehicleInventoryMgmt;
    private List<RentalStore> listRentalStore;
    private VehicleRentalSystem vehicleRentalSystem;
    private VehicleDAO vehicleDAO;
    @Before
    public void dataSetup(){
        vehicleDAO = new VehicleDAO();
        listUser = DataSetup.setUpUsers();
        listVehicle = DataSetup.setUpVehicles();
        listCities = DataSetup.setUpCity();
        listVehicleInventoryMgmt = DataSetup.setupVehicleInventory(vehicleDAO, listVehicle);
        listRentalStore = DataSetup.setUpStore(listVehicleInventoryMgmt, listCities);
        vehicleRentalSystem = VehicleRentalSystem.getInstance();
        vehicleRentalSystem.init(listUser, listRentalStore);
    }

    @Test
    public void testData(){
        Assert.assertNotNull(listUser);
        Assert.assertNotNull(listVehicle);
        Assert.assertNotNull(listCities);
        Assert.assertNotNull(listVehicleInventoryMgmt);
        Assert.assertNotNull(listRentalStore);
        Assert.assertNotNull(vehicleRentalSystem);
    }

    @Test
    public void testIntegration() throws ExecutionException, InterruptedException {
        RentalStore rentalStore = vehicleRentalSystem.getStoreForThisCity(listCities.get(0));
        Assert.assertNotNull(rentalStore);
        List<Vehicle> listVehicleDisplay = rentalStore.getVehicleInventoryMgmt().getVehicles();
        Assert.assertNotNull(listVehicleDisplay);
        Vehicle vehicleReserved = listVehicleDisplay.get(0);

        Reservation reservation = ReservationController.createReservation(vehicleReserved, listUser.get(0), rentalStore, new Date(), new Date(), new Date());
        Invoice invoice = new Invoice(reservation, 1000.0);
        Payment payment = new UPIPayment(invoice);
        Assert.assertNotNull(reservation);
        listVehicleDisplay = rentalStore.getVehicleInventoryMgmt().getVehicles();
        Assert.assertEquals(false, listVehicleDisplay.contains(vehicleReserved));
        ReservationController.completeReservation(vehicleReserved, rentalStore);
        listVehicleDisplay = rentalStore.getVehicleInventoryMgmt().getVehicles();
        Assert.assertEquals(true, listVehicleDisplay.contains(vehicleReserved));
    }

    @Test
    public void testIntegrationConcurrency() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        CompletableFuture.runAsync(() -> {
            try {
                RentalStore rentalStore = vehicleRentalSystem.getStoreForThisCity(listCities.get(0));
                List<Vehicle> listVehicleDisplay = rentalStore.getVehicleInventoryMgmt().getVehicles();
                Assert.assertNotNull(listVehicleDisplay);
                Vehicle vehicleReserved = listVehicleDisplay.get(0);
                Reservation reservation = ReservationController.createReservation(vehicleReserved, listUser.get(0), rentalStore, new Date(), new Date(), new Date());
                System.out.println(reservation);
            }catch (Exception e){
                System.out.println("Exception");
            }
        }, executorService);

        CompletableFuture.runAsync(() -> {
            try {
                RentalStore rentalStore = vehicleRentalSystem.getStoreForThisCity(listCities.get(0));
                List<Vehicle> listVehicleDisplay = rentalStore.getVehicleInventoryMgmt().getVehicles();
                Assert.assertNotNull(listVehicleDisplay);
                Vehicle vehicleReserved = listVehicleDisplay.get(0);
                Reservation reservation = ReservationController.createReservation(vehicleReserved, listUser.get(1), rentalStore, new Date(), new Date(), new Date());
                System.out.println(reservation);
            }catch (Exception e){
                System.out.println("Exception");
            }
        }, executorService);
    }
}
