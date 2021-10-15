package com.example.jobboards.model;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Job {
    @Id
    @GeneratedValue
    private Integer jobId;

    @NotNull
    private String title;
    @NotNull
    private String description;
    @NotNull
    private Boolean status;

    @ManyToMany
    /*@JoinTable(name = "job_applicant",
    joinColumns = @JoinColumn(name ="jobId"),
    inverseJoinColumns = @JoinColumn(name = "applicantId"))*/
    private List<Applicant> applicants;

    public void addApplicant(Applicant applicant){applicants.add(applicant);}


}
