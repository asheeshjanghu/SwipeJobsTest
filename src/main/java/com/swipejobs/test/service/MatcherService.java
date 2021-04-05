package com.swipejobs.test.service;

import com.swipejobs.test.model.Job;
import com.swipejobs.test.model.Worker;
import org.springframework.stereotype.Service;

public interface MatcherService {

    /**
     * matches top n jobs for a worker from an available list of jobs
     * @param worker the worker for whom we want to find matching jobs
     * @param availableJobs the collection of available jobs to select from
     * @param n the maximum number of preferred jobs to provide
     * @return the list of best matching jobs limited by number n
     */
    Job [] getMatchingJobs(Worker worker, Job[] availableJobs, int n);
}
