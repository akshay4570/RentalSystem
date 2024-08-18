import com.github.javafaker.Faker;
import dao.VehicleDAO;
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
            List<User> listUsers = setUpUsers();
            List<Vehicle> listVehicle = setUpVehicles();
            List<City> listCities = setUpCity();
            VehicleInventoryMgmt vehicleInventoryMgmt = new VehicleInventoryMgmt(vehicleDAO);
            vehicleInventoryMgmt.addVehicles(listVehicle);
            List<RentalStore> listRentalStore = setUpStore(vehicleInventoryMgmt, listCities);

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

//        VehicleRentalSystem vehicleRentalSystem = new VehicleRentalSystem(listUsers, )
    }

    private static List<RentalStore> setUpStore(VehicleInventoryMgmt vehicleInventoryMgmt, List<City> listCities) {
        List<RentalStore> listRentalStore = new ArrayList<>();
        for(int i=0;i<10;i++){
            listRentalStore.add(new RentalStore(vehicleInventoryMgmt, listCities.get(i)));
        }
        return listRentalStore;
    }

    private static List<City> setUpCity() {
        List<City> listCity = new ArrayList<>();
        Faker faker = new Faker();
        for (int i = 0; i < 20; i++) {
            listCity.add(new City(faker.address().cityName(), faker.address().streetAddress(), faker.address().zipCode()));
        }
        return listCity;
    }


    private static List<Vehicle> setUpVehicles() {
        List<Vehicle> listVehicle = new ArrayList<>();
        listVehicle.add(new Bike(new VehicleRegistrationDetails("Yamaha", "blue", "Ram"), new VehicleSpecs(45.0, 150.0, 2), Status.ACTIVE));
        listVehicle.add(new Bike(new VehicleRegistrationDetails("BMW", "black", "Shyam"), new VehicleSpecs(20.0, 350.0, 4), Status.ACTIVE));
        listVehicle.add(new Car(new VehicleRegistrationDetails("Benz", "red", "Pape"), new VehicleSpecs(10.0, 1500.0, 8), Status.ACTIVE));
        listVehicle.add(new Car(new VehicleRegistrationDetails("Bugatti", "blue", "Amar"), new VehicleSpecs(4.0, 2050.0, 10), Status.INACTIVE));
        return listVehicle;
    }

    private static List<User> setUpUsers() {
        List<User> listUsers = new ArrayList<>();
        Faker faker = new Faker();
        for(int i=0;i<100;i++){
            listUsers.add(new User(faker.name().firstName(), faker.business().creditCardNumber(), faker.business().creditCardNumber()));
        }
        return listUsers;
    }
}