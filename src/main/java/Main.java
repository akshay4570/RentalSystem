import com.github.javafaker.Faker;
import dao.VehicleDAO;
import data.DataSetup;
import invoice.Invoice;
import location.City;
import payment.Payment;
import payment.UPIPayment;
import reservation.Reservation;
import reservation.ReservationStatus;
import store.RentalStore;
import user.User;
import vehicle.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        try {
            //Setup Vehicle DB Connection
            VehicleDAO vehicleDAO = new VehicleDAO();
            List<User> listUsers = DataSetup.setUpUsers();
            List<Vehicle> listVehicle = DataSetup.setUpVehicles();
            List<City> listCities = DataSetup.setUpCity();
            List<VehicleInventoryMgmt> listVehicleMgmt = DataSetup.setupVehicleInventory(vehicleDAO, listVehicle);
            List<RentalStore> listRentalStore = DataSetup.setUpStore(listVehicleMgmt, listCities);

            VehicleRentalSystem vehicleRentalSystem = VehicleRentalSystem.getInstance();
            vehicleRentalSystem.init(listUsers, listRentalStore);

            //Simulation

            //1. User visits the Website
            User user = listUsers.get(0);

            //2. Gets the Rental Store details in their city
            RentalStore rentalStore = vehicleRentalSystem.getStoreForThisCity(listCities.get(0));

            //3. Fetch the Details of all the Vehicles in the Store
            List<Vehicle> listVehicleDisplay = rentalStore.getVehicleInventoryMgmt().getVehicles();

            //4. Selects the Vehicle of interest and Reserves the same
            Reservation reservation = new Reservation(listVehicleDisplay.get(0), user, new Date(), new Date(), new Date());
            reservation.setReservationStatus(ReservationStatus.RESERVED);

            //5. Generate a Bill against the same Reservation with Date Returned
            Invoice invoice = new Invoice(reservation, 100.0);

            //6. Payment
            Payment payment = new UPIPayment(invoice);
            payment.process();
            reservation.setReservationStatus(ReservationStatus.COMPLETED);


        }catch (Exception e){
            System.out.println("Exception "+e.getMessage());
            System.out.println(Arrays.toString(Arrays.stream(e.getStackTrace()).toArray()));
        }
    }


}