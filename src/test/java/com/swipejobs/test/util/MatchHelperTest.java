package com.swipejobs.test.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.swipejobs.test.model.Job;
import com.swipejobs.test.model.JobSearchAddress;
import com.swipejobs.test.model.Location;
import com.swipejobs.test.model.Worker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MatchHelperTest {

    private MatchHelper matchHelper;
    private ObjectMapper objectMapper;

    @Value("classpath:testdata/jobs.json")
    Resource jobsResourceFile;

    @Value("classpath:testdata/workers.json")
    Resource workersResourceFile;

    private Job[] jobs = null;
    private Worker[] workers = null;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        matchHelper = new MatchHelperImpl(new DistanceCalculatorImpl());
        try {
            jobs = objectMapper.readValue(jobsResourceFile.getFile(), Job[].class);
            workers = objectMapper.readValue(workersResourceFile.getFile(), Worker[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    void testThat_IsJobWithinRequiredDistance_ReturnsTrue_When_WithinDistanceLimit() throws IOException {
        JobSearchAddress jobSearchAddress = workers[0].getJobSearchAddress();
        Location jobLocation = jobs[37].getLocation();
        assertEquals(true, matchHelper.isJobWithinRequiredDistance(jobSearchAddress, jobLocation));
    }

    @Test
    void testThat_IsJobWithinRequiredDistance_ReturnsFalse_When_Not_WithinDistanceLimit() throws IOException {
        JobSearchAddress jobSearchAddress = workers[0].getJobSearchAddress();
        Location jobLocation = jobs[0].getLocation();
        assertEquals(false, matchHelper.isJobWithinRequiredDistance(jobSearchAddress, jobLocation));
    }

    @Test
    void testThat_MatchingSkills_With_JobTitle_Is_Considered() {
        List<String> workerSkills = workers[0].getSkills();
        String jobTitle = jobs[37].getJobTitle();
        assertEquals(true, matchHelper.isSkillMatchingJobTitle(workerSkills, jobTitle));
    }

    @Test
    void testThat_NonMatchingSkills_With_JobTitle_Is_Not_Considered() {
        List<String> workerSkills = workers[0].getSkills();
        String jobTitle = jobs[0].getJobTitle();
        assertEquals(false, matchHelper.isSkillMatchingJobTitle(workerSkills, jobTitle));
    }

    @Test
    void testThat_When_Worker_Has_RequiredCertificates_For_Job() {
        List<String> requiredCertificates = jobs[37].getRequiredCertificates();
        List<String> workerCertificates = workers[0].getCertificates();
        assertTrue(matchHelper.hasRequiredCertificates(workerCertificates, requiredCertificates));
    }

    @Test
    void testThat_When_Worker_DoesNot_Have_RequiredCertificates_For_Job() {
        List<String> requiredCertificates = jobs[0].getRequiredCertificates();
        List<String> workerCertificates = workers[0].getCertificates();
        assertFalse(matchHelper.hasRequiredCertificates(workerCertificates, requiredCertificates));
    }
}