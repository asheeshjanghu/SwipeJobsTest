package com.swipejobs.test.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {
    @Value("${maxRelevantJobsLimit:3}")
    private int maxRelevantJobsLimit;

    @Value("${workerApiUrl:https://test.swipejobs.com/api/workers}")
    private String workerApiUrl;

    @Value("${jobApiUrl:https://test.swipejobs.com/api/jobs}")
    private String jobApiUrl;

    public int getMaxRelevantJobsLimit() {
        return maxRelevantJobsLimit;
    }

    public String getWorkerApiUrl() {
        return workerApiUrl;
    }

    public String getJobApiUrl() {
        return jobApiUrl;
    }
}
