package com.example.workshop2_ziyangwang;
import java.util.ArrayList;
import java.util.List;

public class Applicant{
    private final String name;
    private final String phoneNumber;
    private final List<String> selectedCompanies;
    private final String skills;


    // Constructor
    public Applicant() {
        this.name = "";
        this.phoneNumber = "";
        this.selectedCompanies = new ArrayList<>();
        this.skills = "";
    }

    public Applicant(String name, String phoneNumber, List<String> selectedCompanies, String skills) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.selectedCompanies = selectedCompanies != null ? selectedCompanies : new ArrayList<>();
        this.skills = skills;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSkills() {
        return skills;
    }

    public List<String> getSelectedCompanies() {
        return selectedCompanies;
    }

}
