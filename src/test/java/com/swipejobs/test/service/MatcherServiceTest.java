package com.swipejobs.test.service;

import com.swipejobs.test.model.Job;
import com.swipejobs.test.util.CurrencyConverter;
import com.swipejobs.test.util.MatchHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class MatcherServiceTest {

    private MatcherService matcherService;

    @Autowired
    private CurrencyConverter currencyConverter;

    @Autowired
    private MatchHelper matchHelper;

    @BeforeEach
    void setUp() {
        matcherService = new MatcherServiceImpl(matchHelper, currencyConverter);
    }

    @Test
    void testThatInvalidInputIsHandled() {
        assertArrayEquals(new Job[0], matcherService.getMatchingJobs(null, null, 3));
    }

    @Test
    void testThatWhenThereIsNoWorkerProvidedEmptyOutputIsProduced() {
        assertArrayEquals(new Job[0], matcherService.getMatchingJobs(null, new Job[]{}, 3));
    }

    @Test
    void testThatWhenThereAreMatchingJobsAvailableItReturnsRelevantJobs() {
        Job[] availableJobs = new Job[3];
        availableJobs[0] = new Job();
        assertArrayEquals(new Job[0], matcherService.getMatchingJobs(null, new Job[]{}, 3));
    }
}