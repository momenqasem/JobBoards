package com.example.jobboards.service;

import com.example.jobboards.model.Applicant;
import com.example.jobboards.model.Job;
import com.example.jobboards.repository.ApplicantRepository;
import com.example.jobboards.repository.JobRepository;
import com.example.jobboards.response.JobInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class ApplicantService {
    @PersistenceContext
    private EntityManager entityManager;
    private final ApplicantRepository applicantRepository;
    private final JobRepository jobRepository;

    @Autowired
    public ApplicantService(ApplicantRepository applicantRepository, JobRepository jobRepository) {
        this.applicantRepository = applicantRepository;
        this.jobRepository = jobRepository;
    }

    public void registerApplicant(Applicant applicant) {
        applicantRepository.save(applicant);
    }

    public List<JobInfo> getOpenJobs() {
        return applicantRepository.getOpenJobs();
    }

    public void applyJob( Integer jobId,Integer applicantId){
        Job j =  jobRepository.getOne(jobId);
        Applicant a = applicantRepository.getOne(applicantId);
        j.addApplicant(a);
        jobRepository.save(j);
    }


}
