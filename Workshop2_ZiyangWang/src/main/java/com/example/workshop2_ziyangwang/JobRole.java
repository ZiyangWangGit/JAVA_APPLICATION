package com.example.workshop2_ziyangwang;


public class JobRole {
    private final String jobTitle;
    private final String description;

    // Constructor
    public JobRole(String jobRole,String description){
        this.jobTitle = jobRole;
        this.description = description;
    }

    // Getters
    public String getJobTitle() {
        return jobTitle;
    }

    public String getJobDescription() {
        return description;
    }

}
