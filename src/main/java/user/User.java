package user;

import java.util.UUID;

public class User {
    private String userId;
    private String name;
    private String govtProof;
    private String drivingLicenseDetails;

    public User(String name, String govtProof, String drivingLicenseDetails) {
        this.userId = UUID.randomUUID().toString();
        this.name = name;
        this.govtProof = govtProof;
        this.drivingLicenseDetails = drivingLicenseDetails;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getGovtProof() {
        return govtProof;
    }

    public String getDrivingLicenseDetails() {
        return drivingLicenseDetails;
    }
}
