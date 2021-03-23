package com.swipejobs.test.service;

import com.swipejobs.test.model.Worker;

import java.util.List;

/**
 * A service to get workers
 */
public interface WorkerService {

    /**
     * Fetches a list of available workers
     * @return list of available workers
     */
    List<Worker> fetchWorkers();
}
