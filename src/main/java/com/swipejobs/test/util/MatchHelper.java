package com.swipejobs.test.util;

import com.swipejobs.test.model.Availability;
import com.swipejobs.test.model.JobSearchAddress;
import com.swipejobs.test.model.Location;

import java.util.List;

/**
 * A helper to filter jobs based on different conditions
 * for example : based on distance, skills, certificates
 */
public interface MatchHelper {

    /**
     * Checks whether the job location is within the preferred distance of the worker
     * @param workerPreferredSearchAddress
     * @param jobLocation
     * @return
     */
    boolean isJobWithinRequiredDistance(JobSearchAddress workerPreferredSearchAddress, Location jobLocation);

    /**
     * checks whether the job is available on required days
     * @param workerPreferredAvailabilityDays
     * @param jobAvailabilityDays
     * @return
     */
    boolean isJobAvailableOnRequiredDays(List<Availability> workerPreferredAvailabilityDays,List<Availability> jobAvailabilityDays);

    /**
     * checks whether the workers skills match with the job required title
     * @param workerSkills
     * @param jobTitle
     * @return
     */
    boolean isSkillMatchingJobTitle(List<String> workerSkills, String jobTitle);

    /**
     * checks whether the worker has required certificates required in the job
     * @param workerCertificates
     * @param requiredCertificates
     * @return
     */
    boolean hasRequiredCertificates(List<String> workerCertificates, List<String> requiredCertificates);
}
