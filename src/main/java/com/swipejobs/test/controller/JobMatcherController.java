package com.swipejobs.test.controller;

import com.swipejobs.test.model.Job;
import com.swipejobs.test.model.Worker;
import com.swipejobs.test.service.JobService;
import com.swipejobs.test.service.MatcherService;
import com.swipejobs.test.service.WorkerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class JobMatcherController {

    private static final int TOP_N = 3;
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
        System.out.println("Start Fetching Jobs");
        Job[] jobs = jobService.fetchJobs();
        System.out.println("Finished Fetching Jobs");
        Worker[] workers = workerService.fetchWorkers();
        System.out.println("Finished Fetching workers");
        Optional<Worker> optionalWorker = Arrays.stream(workers).filter(worker -> worker.getUserId() == workerId).findFirst();
        if (optionalWorker.isPresent()){
            return matcherService.getMatchingJobs(optionalWorker.get(), jobs, TOP_N);
        }
        return jobs;
    }
}
