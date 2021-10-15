package com.example.jobboards.repository;

import com.example.jobboards.model.Applicant;
import com.example.jobboards.response.JobInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant,Integer> {

    @Query("select new com.example.jobboards.response.JobInfo( jobId,title, description) from Job where status=true ")
    public List<JobInfo> getOpenJobs();










}
