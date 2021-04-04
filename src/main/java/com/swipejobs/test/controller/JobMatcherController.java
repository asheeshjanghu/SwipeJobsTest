package com.swipejobs.test.controller;

import com.swipejobs.test.model.Job;
import com.swipejobs.test.model.Worker;
import com.swipejobs.test.service.JobService;
import com.swipejobs.test.service.WorkerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class JobMatcherController {

    private final JobService jobService;
    private final WorkerService workerService;

    public JobMatcherController(JobService jobService, WorkerService workerService) {
        this.jobService = jobService;
        this.workerService = workerService;
    }

    @GetMapping("/api/matches")
    public List<Job> getMatchingJobs() {
        System.out.println("Start Fetching Jobs");
        Job[] jobs = jobService.fetchJobs();
        System.out.println("Finished Fetching Jobs");
        Worker[] workers = workerService.fetchWorkers();
        System.out.println("Finished Fetching workers");
        return Arrays.asList(jobs);
    }
}
