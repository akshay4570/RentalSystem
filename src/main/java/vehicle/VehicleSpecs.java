package vehicle;

import java.util.Date;

public class VehicleSpecs {

    private Double mileage;
    private Double cc;
    private int numOfCylinders;
    private long lastPollutionCheck;
    private long lastService;

    public VehicleSpecs(Double mileage, Double cc, int numOfCylinders) {
        this.mileage = mileage;
        this.cc = cc;
        this.numOfCylinders = numOfCylinders;
        this.lastPollutionCheck = 100;
        this.lastService = 50;
    }

    public Double getMileage() {
        return mileage;
    }

    public void setMileage(Double mileage) {
        this.mileage = mileage;
    }

    public Double getCc() {
        return cc;
    }

    public void setCc(Double cc) {
        this.cc = cc;
    }

    public int getNumOfCylinders() {
        return numOfCylinders;
    }

    public void setNumOfCylinders(int numOfCylinders) {
        this.numOfCylinders = numOfCylinders;
    }

    public long getLastPollutionCheck() {
        return lastPollutionCheck;
    }

    public void setLastPollutionCheck(long lastPollutionCheck) {
        this.lastPollutionCheck = lastPollutionCheck;
    }

    public long getLastService() {
        return lastService;
    }

    public void setLastService(long lastService) {
        this.lastService = lastService;
    }
}
