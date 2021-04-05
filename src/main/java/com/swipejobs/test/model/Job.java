package com.swipejobs.test.model;

import java.util.List;

public class Job {

    private boolean driverLicenseRequired;
    private List<String> requiredCertificates = null;
    private Location location;
    private String billRate;
    private int workersRequired;
    private String startDate;
    private String about;
    private String jobTitle;
    private String company;
    private String guid;
    private int jobId;

    public boolean isDriverLicenseRequired() {
        return driverLicenseRequired;
    }

    public List<String> getRequiredCertificates() {
        return requiredCertificates;
    }

    public Location getLocation() {
        return location;
    }

    public String getBillRate() {
        return billRate;
    }

    public int getWorkersRequired() {
        return workersRequired;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getAbout() {
        return about;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getCompany() {
        return company;
    }

    public String getGuid() {
        return guid;
    }

    public int getJobId() {
        return jobId;
    }
}