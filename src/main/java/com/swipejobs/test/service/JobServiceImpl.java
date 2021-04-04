package com.swipejobs.test.service;

import com.swipejobs.test.model.Job;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JobServiceImpl implements JobService {

    private final RestTemplate restTemplate;

    private static final String url = "https://test.swipejobs.com/api/workers";

    public JobServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Fetches a list of jobs
     *
     * @return list of available jobs
     */
    @Override
    public Job[] fetchJobs() {
        Job[] jobs = restTemplate.getForEntity(url, Job[].class).getBody();
        for (Job job : jobs) System.out.println(job.toString());
        return jobs;
    }
}
