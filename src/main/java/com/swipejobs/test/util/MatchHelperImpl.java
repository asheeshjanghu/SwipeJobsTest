package com.swipejobs.test.util;

import com.swipejobs.test.model.Availability;
import com.swipejobs.test.model.JobSearchAddress;
import com.swipejobs.test.model.Location;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchHelperImpl implements MatchHelper {

    private final DistanceCalculator distanceCalculator;

    public MatchHelperImpl(DistanceCalculator distanceCalculator) {
        this.distanceCalculator = distanceCalculator;
    }


    @Override
    public boolean isJobWithinRequiredDistance(JobSearchAddress workerPreferredSearchAddress, Location jobLocation) {
        double distanceFromLatLonInKm = distanceCalculator.getDistance(
                workerPreferredSearchAddress.getLatitude(), workerPreferredSearchAddress.getLongitude(),
                jobLocation.getLatitude(), jobLocation.getLongitude());

        boolean isWithinRequiredDistance = workerPreferredSearchAddress.getMaxJobDistance() <= distanceFromLatLonInKm;

        return isWithinRequiredDistance;
    }

    @Override
    public boolean isJobAvailableOnRequiredDays(List<Availability> workerPreferredAvailabilityDays, List<Availability> jobAvailabilityDays) {
        return false;
    }

    @Override
    public boolean isSkillMatchingJobTitle(List<String> workerSkills, String jobTitle) {
        boolean skillMatched = workerSkills.stream().anyMatch(jobTitle::equals);
        return skillMatched;
    }

    @Override
    public boolean hasRequiredCertificates(List<String> workerCertificates, List<String> requiredCertificates) {
        return requiredCertificates.stream().allMatch((cert) -> {
            for (String workerCert : workerCertificates) {
                if (workerCert != null && workerCert.equals(cert)) return true;
            }
            return false;
        });
    }



}
