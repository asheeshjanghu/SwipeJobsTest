package com.swipejobs.test.model;

import java.util.List;

public class Worker {
    private int rating;
    private boolean isActive;
    private List<String> certificates = null;
    private List<String> skills = null;
    private JobSearchAddress jobSearchAddress;
    private String transportation;
    private boolean hasDriversLicense;
    private List<Availability> availability = null;
    private String phone;
    private String email;
    private Name name;
    private int age;
    private String guid;
    private int userId;

    public int getRating() {
        return rating;
    }

    public boolean isActive() {
        return isActive;
    }

    public List<String> getCertificates() {
        return certificates;
    }

    public List<String> getSkills() {
        return skills;
    }

    public JobSearchAddress getJobSearchAddress() {
        return jobSearchAddress;
    }

    public String getTransportation() {
        return transportation;
    }

    public boolean isHasDriversLicense() {
        return hasDriversLicense;
    }

    public List<Availability> getAvailability() {
        return availability;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Name getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGuid() {
        return guid;
    }

    public int getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "rating=" + rating +
                ", isActive=" + isActive +
                ", certificates=" + certificates +
                ", skills=" + skills +
                ", jobSearchAddress=" + jobSearchAddress +
                ", transportation='" + transportation + '\'' +
                ", hasDriversLicense=" + hasDriversLicense +
                ", availability=" + availability +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", name=" + name +
                ", age=" + age +
                ", guid='" + guid + '\'' +
                ", userId=" + userId +
                '}';
    }
}