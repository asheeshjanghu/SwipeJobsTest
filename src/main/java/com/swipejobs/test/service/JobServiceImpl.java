package com.swipejobs.test.service;

import com.swipejobs.test.config.AppConfig;
import com.swipejobs.test.model.Job;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class JobServiceImpl implements JobService {

    private static final Logger logger = LoggerFactory.getLogger(JobServiceImpl.class);

    private final RestTemplate restTemplate;

    @Autowired
    AppConfig config;

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
        Job[] jobs = new Job[0];
        try {
            ResponseEntity<Job[]> responseEntity = restTemplate.getForEntity(config.getJobApiUrl(), Job[].class);
            if (responseEntity.getBody() == null) {
                logger.error("No body in the response to get jobs.");
            } else if (responseEntity.getStatusCode() != HttpStatus.OK) {
                logger.error("Jobs Request failed with status code: " + responseEntity.getStatusCode());
            } else {
                jobs = responseEntity.getBody();
                logger.info("Success: Retrieved jobs: " + jobs);
            }
        } catch (RestClientException e) {
            e.printStackTrace();
        }

        return jobs;
    }
}
