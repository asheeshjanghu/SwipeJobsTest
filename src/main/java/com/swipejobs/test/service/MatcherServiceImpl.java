package com.swipejobs.test.service;

import com.swipejobs.test.model.Job;
import com.swipejobs.test.model.Worker;
import com.swipejobs.test.util.CurrencyConverter;
import com.swipejobs.test.util.MatchHelper;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MatcherServiceImpl implements MatcherService {

    private final MatchHelper matchHelper;
    private final CurrencyConverter currencyConverter;

    public MatcherServiceImpl(MatchHelper matchHelper, CurrencyConverter currencyConverter) {
        this.matchHelper = matchHelper;
        this.currencyConverter = currencyConverter;
    }

    /**
     * matches top n jobs for a worker from an available list of jobs
     *
     * @param worker        the worker for whom we want to find matching jobs
     * @param availableJobs the collection of available jobs to select from
     * @param n             the maximum number of preferred jobs to provide
     * @return the list of best matching jobs limited by number n ordered by most relevant
     */
    @Override
    public Job[] getMatchingJobs(Worker worker, Job[] availableJobs, int n) {

        if (availableJobs == null || availableJobs.length == 0 || worker == null) return new Job[0];

        Job[] matchingJobs = Arrays.stream(availableJobs)
                .filter(job -> {
                            if (job.isDriverLicenseRequired()) return worker.isHasDriversLicense();
                            else return true;
                        }
                )
                .peek(job ->
                        System.out.println("Licence: " + job.toString()))
                .filter(job ->
                        matchHelper.isJobWithinRequiredDistance(worker.getJobSearchAddress(), job.getLocation()))
                .peek(job ->
                        System.out.println("Distance: " + job.toString()))
                .filter(job ->
                        matchHelper.hasRequiredCertificates(worker.getCertificates(), job.getRequiredCertificates())).peek(job -> System.out.println("Licence: " + job.toString()))
                .peek(job ->
                        System.out.println("Cert: " + job.toString()))
                .filter(job ->
                        matchHelper.isSkillMatchingJobTitle(worker.getSkills(), job.getJobTitle()))
                .peek(job ->
                        System.out.println("Skills: " + job.toString()))
                .sorted((a, b) ->
                        currencyConverter.getBillingRate(b.getBillRate()).subtract(currencyConverter.getBillingRate(a.getBillRate())).intValue())
                .peek(job ->
                        System.out.println("BillRate: " + job.toString()))
                .limit(n)
                .peek(job ->
                        System.out.println("Limit: " + job.toString()))
                .toArray(Job[]::new);

        return matchingJobs;
    }
}
