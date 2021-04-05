package com.swipejobs.test.controller;

import com.swipejobs.test.config.AppConfig;
import com.swipejobs.test.model.Job;
import com.swipejobs.test.model.Worker;
import com.swipejobs.test.service.JobService;
import com.swipejobs.test.service.JobServiceImpl;
import com.swipejobs.test.service.MatcherService;
import com.swipejobs.test.service.WorkerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class JobMatcherController {
    private static final Logger logger = LoggerFactory.getLogger(JobMatcherController.class);

    @Autowired
    AppConfig config;
    private final JobService jobService;
    private final WorkerService workerService;
    private final MatcherService matcherService;

    public JobMatcherController(JobService jobService, WorkerService workerService, MatcherService matcherService) {
        this.jobService = jobService;
        this.workerService = workerService;
        this.matcherService = matcherService;
    }

    @GetMapping("/api/matches/{workerId}")
    public Job[] getMatchingJobs(@PathVariable int workerId) {
        logger.info("Received request for matching jobs for worker:"+workerId);

        Job[] jobs = jobService.fetchJobs();
        if (jobs == null || jobs.length == 0) {
            logger.error("No jobs available to select from.");
        } else {
            Worker[] workers = workerService.fetchWorkers();
            if (workers == null || workers.length == 0) {
                logger.error("No worker available to find the worker from.");
            } else {
                Optional<Worker> optionalWorker = Arrays.stream(workers).filter(worker -> worker.getUserId() == workerId).findFirst();
                if (optionalWorker.isPresent()){
                    logger.info("Find matching jobs for "+optionalWorker.get());
                    jobs = matcherService.getMatchingJobs(optionalWorker.get(), jobs, config.getMaxRelevantJobsLimit());
                    logger.info("Successfully found matching jobs: "+jobs);
                } else {
                    logger.error("Provided worker id does not match with any available workers");
                }
            }
        }

        return jobs;
    }
}
