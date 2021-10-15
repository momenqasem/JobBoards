package com.example.jobboards.response;

import com.example.jobboards.model.Applicant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JobInfo {
    private Integer id;
    private String title;
    private String description;

}
