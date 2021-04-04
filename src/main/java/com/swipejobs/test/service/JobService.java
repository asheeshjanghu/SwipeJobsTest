package com.swipejobs.test.service;

import com.swipejobs.test.model.Job;

/**
 * A Service responsible for fetching jobs
 */
@FunctionalInterface
public interface JobService {

    /**
     * Fetches a list of jobs
     *
     * @return list of available jobs
     */
    Job[] fetchJobs();
}
