package com.example.jobboards.controller;

import com.example.jobboards.model.Applicant;
import com.example.jobboards.response.JobInfo;
import com.example.jobboards.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ApplicantController {
    private final ApplicantService applicantService;

    @Autowired
    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @GetMapping("/listopenjobs")
    public List<JobInfo> getOpenJobs(){
        return applicantService.getOpenJobs();
    }

    @PostMapping("/newapplicant")
    public void registerApplicant(@RequestBody Applicant applicant){
        applicantService.registerApplicant(applicant);
    }
    @PostMapping("/{applicantId}/applyjob")
    public void applyJob(@RequestParam Integer jobId,@PathVariable Integer applicantId)
    {
    applicantService.applyJob(jobId,applicantId);
    }

}
