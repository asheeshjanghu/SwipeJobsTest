package com.swipejobs.test.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Job {

    private Integer rating;
    private Boolean isActive;
    private List<String> certificates = null;
    private List<String> skills = null;
    private JobSearchAddress jobSearchAddress;
    private String transportation;
    private Boolean hasDriversLicense;
    private List<Availability> availability = null;
    private String phone;
    private String email;
    private Name name;
    private Integer age;
    private String guid;
    private Integer userId;

    public Integer getRating() {
        return rating;
    }

    public Boolean getActive() {
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

    public Boolean getHasDriversLicense() {
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

    public Integer getAge() {
        return age;
    }

    public String getGuid() {
        return guid;
    }

    public Integer getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "Job{" +
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
