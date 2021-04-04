package com.swipejobs.test.service;

import com.swipejobs.test.model.Worker;

/**
 * A service to get workers
 */
@FunctionalInterface
public interface WorkerService {

    /**
     * Fetches a list of available workers
     * @return list of available workers
     */
    Worker[] fetchWorkers();
}
