package data;

import com.github.javafaker.Faker;
import dao.VehicleDAO;
import location.City;
import store.RentalStore;
import user.User;
import vehicle.*;

import java.util.ArrayList;
import java.util.List;

public class DataSetup {
    public static List<RentalStore> setUpStore(List<VehicleInventoryMgmt> listVehicleMgmt, List<City> listCities) {
        List<RentalStore> listRentalStore = new ArrayList<>();
        for(int i=0;i<10;i++){
            listRentalStore.add(new RentalStore(listVehicleMgmt.get(i), listCities.get(i)));
        }
        return listRentalStore;
    }

    public static List<City> setUpCity() {
        List<City> listCity = new ArrayList<>();
        Faker faker = new Faker();
        for (int i = 0; i < 20; i++) {
            listCity.add(new City(faker.address().cityName(), faker.address().streetAddress(), faker.address().zipCode()));
        }
        return listCity;
    }


    public static List<VehicleInventoryMgmt> setupVehicleInventory(VehicleDAO vehicleDAO, List<Vehicle> listVehicle){
        List<VehicleInventoryMgmt> listVehicleMgmt = new ArrayList<>();
        try {
            for(int i=0;i<10;i++) {
                VehicleInventoryMgmt vehicleInventoryMgmt = new VehicleInventoryMgmt(vehicleDAO);
                vehicleInventoryMgmt.addVehicles(listVehicle.subList(i*10, (i+1)*10));
                listVehicleMgmt.add(vehicleInventoryMgmt);
            }
        }catch (Exception e){
            System.out.println("Exception " +e.getMessage());
        }
        return listVehicleMgmt;
    }

    public static List<Vehicle> setUpVehicles() {
        List<Vehicle> listVehicle = new ArrayList<>();
        for(int i=0;i<100;i++){
            if(i%2 == 0){
                listVehicle.add(new Bike(new VehicleRegistrationDetails("Yamaha", "blue", "Ram"), new VehicleSpecs(45.0, 150.0, 2), Status.ACTIVE));
            }else{
                listVehicle.add(new Car(new VehicleRegistrationDetails("Benz", "red", "Pape"), new VehicleSpecs(10.0, 1500.0, 8), Status.ACTIVE));
            }
        }
        return listVehicle;
    }

    public static List<User> setUpUsers() {
        List<User> listUsers = new ArrayList<>();
        Faker faker = new Faker();
        for(int i=0;i<100;i++){
            listUsers.add(new User(faker.name().firstName(), faker.business().creditCardNumber(), faker.business().creditCardNumber()));
        }
        return listUsers;
    }
}
