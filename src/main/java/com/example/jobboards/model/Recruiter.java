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
public class Recruiter {
    @Id
    @GeneratedValue
    @NotNull
    private Integer id;
    @NotNull
    private String recruiterName;
    @NotNull
    private String email;
    @NotNull
    private String password;
    @OneToMany(targetEntity = Job.class, cascade = CascadeType.ALL)
    // @JoinColumn(name = "jp_fk", referencedColumnName = "id")
    private List<Job> jobs;

    public void addJob(Job job){
        jobs.add(job);
    }


}
