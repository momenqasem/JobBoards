package com.example.jobboards.service;

import com.example.jobboards.model.Applicant;
import com.example.jobboards.model.Job;
import com.example.jobboards.model.Recruiter;
import com.example.jobboards.repository.JobRepository;
import com.example.jobboards.repository.RecruiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class RecruiterService {
    @PersistenceContext
    private EntityManager entityManager;
    private final RecruiterRepository recruiterRepository;
    private final JobRepository jobRepository;

    @Autowired
    public RecruiterService(RecruiterRepository recruiterRepository, JobRepository jobRepository) {
        this.recruiterRepository = recruiterRepository;
        this.jobRepository = jobRepository;
    }

    public void registerRecruiter(@RequestBody Recruiter recruiter){
        recruiterRepository.save(recruiter);
    }
    public List<Recruiter> getAllRecruiter(){return recruiterRepository.findAll();}
    public List<Job> getJobs(Integer recruiterId){


        return recruiterRepository.getOne(recruiterId).getJobs();
    }

    public void newJob(Job job, Integer recruiterId){
        Recruiter r = recruiterRepository.getOne(recruiterId);
        r.addJob(job);
        recruiterRepository.save(r);

    }


    public List<Applicant> getApplicants(Integer jobId)
    {
        return jobRepository.getOne(jobId).getApplicants();
    }
}
