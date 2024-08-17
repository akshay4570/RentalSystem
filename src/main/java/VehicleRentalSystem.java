import store.RentalStore;
import user.User;

import java.util.List;

public class VehicleRentalSystem {
    private List<User> listUser;
    private List<RentalStore> listRentalStore;

    public VehicleRentalSystem(List<User> listUser, List<RentalStore> listRentalStore) {
        this.listUser = listUser;
        this.listRentalStore = listRentalStore;
    }
}
