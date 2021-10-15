package com.example.jobboards.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Applicant {

 @Id
   private Integer applicantId;
    @NotNull
    private String applicantName;
    @NotNull
    private String password;
    @NotNull
    private String email;
    @NotNull
    private String address;
    @NotNull
    private String phoneNumber;



}
