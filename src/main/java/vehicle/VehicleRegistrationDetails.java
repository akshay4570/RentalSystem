package vehicle;

import java.util.Date;
import java.util.UUID;

public class VehicleRegistrationDetails {

    private String chassisNo;
    private String regNo;
    private String modelName;
    private String colour;
    private String vehicleOwner;
    private Date dateOfRegistration;

    public VehicleRegistrationDetails(String modelName, String colour, String vehicleOwner) {
        this.chassisNo = UUID.randomUUID().toString();
        this.regNo = UUID.randomUUID().toString();
        this.modelName = modelName;
        this.colour = colour;
        this.vehicleOwner = vehicleOwner;
        this.dateOfRegistration = new Date();
    }

    public String getChassisNo() {
        return chassisNo;
    }

    public void setChassisNo(String chassisNo) {
        this.chassisNo = chassisNo;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getVehicleOwner() {
        return vehicleOwner;
    }

    public void setVehicleOwner(String vehicleOwner) {
        this.vehicleOwner = vehicleOwner;
    }

    public Date getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(Date dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }
}
