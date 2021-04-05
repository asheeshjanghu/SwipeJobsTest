package com.swipejobs.test.service;

import com.swipejobs.test.config.AppConfig;
import com.swipejobs.test.model.Worker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class WorkerServiceImpl implements WorkerService {

    private static final Logger logger = LoggerFactory.getLogger(WorkerServiceImpl.class);

    private final RestTemplate restTemplate;

    @Autowired
    AppConfig config;

    public WorkerServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Fetches a list of available workers
     *
     * @return list of available workers
     */
    @Override
    public Worker[] fetchWorkers() {
        Worker[] workers = new Worker[0];
        try {
            ResponseEntity<Worker[]> responseEntity = restTemplate.getForEntity(config.getWorkerApiUrl(), Worker[].class);
            if (responseEntity.getBody() == null) {
                logger.error("No body in the response to get workers.");
            } else if (responseEntity.getStatusCode() != HttpStatus.OK) {
                logger.error("Workers Request failed with status code: " + responseEntity.getStatusCode());
            } else {
                workers = responseEntity.getBody();
                logger.info("Success: Retrieved workers: " + workers);
            }
        } catch (RestClientException e) {
            logger.error("Workers Request threw RestClientException. " + e.getMessage());
            e.printStackTrace();
        }

        return workers;
    }
}
