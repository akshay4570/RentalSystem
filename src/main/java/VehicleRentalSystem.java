import location.City;
import store.RentalStore;
import user.User;

import java.util.List;
import java.util.Optional;

//Singleton Class
public class VehicleRentalSystem {
    private List<User> listUser;
    private List<RentalStore> listRentalStore;
    private static volatile VehicleRentalSystem vehicleRentalSystem;

    private VehicleRentalSystem(){};

    public static VehicleRentalSystem getInstance(){
        if(vehicleRentalSystem == null){
            synchronized (VehicleRentalSystem.class){
                if(vehicleRentalSystem == null){
                    vehicleRentalSystem = new VehicleRentalSystem();
                }
            }
        }
        return vehicleRentalSystem;
    }

    public void init(List<User> listUser, List<RentalStore> listRentalStore){
        this.listUser = listUser;
        this.listRentalStore = listRentalStore;
    }

    public List<User> getListUser() {
        return listUser;
    }

    public List<RentalStore> getListRentalStore() {
        return listRentalStore;
    }

    //All the filters go here
    public RentalStore getStoreForThisCity(City city){
        Optional<RentalStore> stores = listRentalStore.stream().filter(obj -> obj.getCity().equals(city)).findAny();
        return stores.orElse(null);
    }
}
