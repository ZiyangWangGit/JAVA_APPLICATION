package com.example.workshop2_ziyangwang;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class ApplicationController extends Application {

    private ApplicationView view;
    private final List<Applicant> applicants = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        view = new ApplicationView();

        view.getViewDetailButton().setOnAction(_ -> handleDetailReviewButtonPress());

        view.getClearButton().setOnAction(_ -> handleClearButtonPress());

        view.getExitButton().setOnAction(_ -> handleExitButtonPress());

        view.getSubmitButton().setOnAction(_ -> handleSubmitButtonPress());
        primaryStage.setTitle("View test");
        primaryStage.setResizable(true);
        primaryStage.setScene(new Scene(view, 555,700));
        primaryStage.show();
    }

    private void handleDetailReviewButtonPress(){
        String selectedJobRoleTitle = view.getJobRoleList().getSelectionModel().getSelectedItem();

        if (selectedJobRoleTitle != null) {
            // Find the JobRole object by its title
            JobRole selectedJobRole = findJobRoleByTitle(selectedJobRoleTitle);
            assert selectedJobRole != null;
            view.getJobDescriptionLabel().setText("Job Role: " + selectedJobRole.getJobTitle() + "\nDescription: " + selectedJobRole.getJobDescription());
        } else {
            // If no job role is selected, display a message
            view.getJobDescriptionLabel().setText("No job role selected.");
        }
    }

    // Helper method to find a JobRole by title
    private JobRole findJobRoleByTitle(String title) {
        for (JobRole jobRole : view.getJobRoles()) {
            if (jobRole.getJobTitle().equals(title)) {
                return jobRole;
            }
        }
        return null;  // Return null if no matching job role is found
    }

    private void handleClearButtonPress(){
        String nameText = view.getNameField().getText().trim();
        String phoneText = view.getPhoneField().getText().trim();
        String skillText = view.getSkillsField().getText().trim();
        if (!nameText.isEmpty() || !phoneText.isEmpty() || !skillText.isEmpty()) {
            view.getNameField().setText("");  // Clear name field
            view.getPhoneField().setText(""); // Clear phone field
            view.getSkillsField().setText(""); //// Clear skill field
        }
    }

    private void handleExitButtonPress(){
        javafx.application.Platform.exit();
    }

    private void handleSubmitButtonPress(){
        String name = view.getNameField().getText().trim();
        String phoneNumber = view.getPhoneField().getText().trim();
        String skills = view.getSkillsField().getText().trim();
        String selectedJobRoleTitle = view.getJobRoleList().getSelectionModel().getSelectedItem();
        List<String> selectedCompanies = new ArrayList<>(view.getCompanyList().getSelectionModel().getSelectedItems());

        if (!name.isEmpty() && !phoneNumber.isEmpty() && !skills.isEmpty() && selectedJobRoleTitle != null){
            Applicant newApplicant = new Applicant(name, phoneNumber, selectedCompanies, skills);
            applicants.add(newApplicant);

            // Clear fields after submission if needed
            view.getNameField().setText("");
            view.getPhoneField().setText("");
            view.getSkillsField().setText("");
            view.getJobRoleList().getSelectionModel().clearSelection();

            view.getStatusLabel().setText("Submitted successfully!\n" +
                    "Name: " + newApplicant.getName() + "\n" +
                    "Phone Number: " + newApplicant.getPhoneNumber() + "\n" +
                    "Skills: " + newApplicant.getSkills()+ "\n" +
                    "Selected Company: " + newApplicant.getSelectedCompanies()
            );
        } else {
            view.getStatusLabel().setText("Please fill in missing fields.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
