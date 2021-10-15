package com.example.jobboards.controller;

import com.example.jobboards.model.Applicant;
import com.example.jobboards.model.Job;
import com.example.jobboards.model.Recruiter;
import com.example.jobboards.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class RecruiterController {
    private final RecruiterService recruiterService;

    @Autowired
    public RecruiterController(RecruiterService recruiterService) {
        this.recruiterService = recruiterService;
    }

    @PostMapping("/newrecruiter")
    public void registerRecruiter(@RequestBody Recruiter recruiter){
        recruiterService.registerRecruiter(recruiter);
    }
    // recruiter response
    @GetMapping("/recruiters")
    public List<Recruiter> getAllRecriter(){return recruiterService.getAllRecruiter();}
     // job response
    @GetMapping("/{recruiterId}/listjobs")
    public List<Job> getJobs(@PathVariable Integer recruiterId){
        return recruiterService.getJobs(recruiterId);
    }
    @PostMapping("/{recruiterId}/newjob")
    public void newJob(@RequestBody Job job,@PathVariable Integer recruiterId){
        recruiterService.newJob(job, recruiterId);

    }
    // #####################################################################################
    // #####################################################################################
    @GetMapping("{recruiterId}/{jobId}/listapplicants")
    public List<Applicant> getApplicants(@PathVariable Integer jobId)
    {
        return recruiterService.getApplicants(jobId);
    }
    // #####################################################################################
}
