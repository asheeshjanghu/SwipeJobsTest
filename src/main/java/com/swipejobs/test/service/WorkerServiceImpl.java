package com.swipejobs.test.service;

import com.swipejobs.test.model.Worker;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WorkerServiceImpl implements WorkerService {

    private final RestTemplate restTemplate;

    private static final String url = "https://test.swipejobs.com/api/workers";

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
        Worker[] workers = restTemplate.getForEntity(url, Worker[].class).getBody();
        for (Worker worker : workers) System.out.println(worker.toString());
        return workers;
    }
}
