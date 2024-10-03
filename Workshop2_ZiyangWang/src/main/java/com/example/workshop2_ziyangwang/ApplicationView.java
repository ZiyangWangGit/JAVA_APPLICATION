package com.example.workshop2_ziyangwang;

import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class ApplicationView extends Pane {

    private List<JobRole> jobRoles;

    private final ListView<String> jobRoleList;
    private final ListView<String> companyList;
    private final Button viewDetailButton;
    private final Button clearButton;
    private final Button exitButton;
    private final Button submitButton;
    private final TextField nameField;
    private final TextField phoneField;
    private final TextField skillsField;
    private final Label jobDescriptionLabel;
    private final Label statusLabel;

    public TextField getNameField() {
        return nameField;
    }

    public TextField getPhoneField(){
        return phoneField;
    }

    public TextField getSkillsField(){
        return skillsField;
    }

    public Button getViewDetailButton(){
        return viewDetailButton;
    }

    public Button getClearButton(){
        return clearButton;
    }

    public Button getExitButton(){
        return exitButton;
    }

    public Button getSubmitButton(){
        return submitButton;
    }

    public Label getJobDescriptionLabel(){
        return jobDescriptionLabel;
    }

    public Label getStatusLabel(){
        return statusLabel;
    }

    private void createJobRoles(){
        jobRoles = new ArrayList<>();

        // Create JobRole instances and add to the list
        jobRoles.add(new JobRole("Frontend Developer", "Design and implement user interfaces for web applications, ensuring a seamless user experience."));
        jobRoles.add(new JobRole("Backend Developer", "Develop and maintain server-side logic, database management, and ensure high performance and responsiveness of applications."));
        jobRoles.add(new JobRole("UX/UI Designer", "Create user-centered designs by understanding business requirements and user feedback, focusing on improving usability and accessibility."));
        jobRoles.add(new JobRole("DevOps Engineer", "Collaborate with development and operations teams to automate deployment processes and improve system reliability."));
        jobRoles.add(new JobRole("Data Scientist", "Analyze complex data sets to derive actionable insights, build predictive models, and contribute to data-driven decision-making."));
    }

    public List<JobRole> getJobRoles() {
        return jobRoles;
    }

    public ListView<String> getJobRoleList() {
        return jobRoleList;
    }

    public ListView<String> getCompanyList() {
        return companyList;
    }

    public ApplicationView(){
        viewDetailButton = new Button("View Job Role Detail");
        viewDetailButton.relocate(10, 185);
        viewDetailButton.setPrefSize(155, 25);

        clearButton = new Button ("Clear");
        clearButton.relocate(10,600);
        clearButton.setPrefSize(100, 25);

        exitButton = new Button("Exit");
        exitButton.relocate(300,600);
        exitButton.setPrefSize(100, 25);

        submitButton = new Button("Submit");
        submitButton.relocate(10,650);
        submitButton.setPrefSize(100, 25);

        Label nameLabel = new Label("Name:");
        nameLabel.relocate(10, 20);
        nameLabel.setPrefSize(100, 30);
        Label phoneLabel = new Label("Phone Number:");
        phoneLabel.relocate(10, 55);
        phoneLabel.setPrefSize(100, 30);
        Label jobRoleLabel = new Label("Job Role:");
        jobRoleLabel.relocate(10, 90);
        jobRoleLabel.setPrefSize(100, 30);
        Label skillLabel = new Label("Skills:");
        skillLabel.relocate(10,305);
        skillLabel.setPrefSize(100, 30);
        Label companyLabel = new Label("Select Companies:");
        companyLabel.relocate(10,405);
        companyLabel.setPrefSize(150, 30);

        nameField = new TextField();
        nameField.relocate(180, 20);
        nameField.setPrefSize(150, 25);

        phoneField = new TextField();
        phoneField.relocate(180, 55);
        phoneField.setPrefSize(150, 25);

        skillsField = new TextField();
        skillsField.relocate(180,305);
        skillsField.setPrefSize(150, 80);

        createJobRoles();

        // Use ListView to display job roles
        jobRoleList = new ListView<>();
        List<String> jobTitles = new ArrayList<>();
        for (JobRole jobRole : jobRoles) {
            jobTitles.add(jobRole.getJobTitle());
        }

        // Populate ListView with job titles
        jobRoleList.setItems(FXCollections.observableArrayList(jobTitles));
        jobRoleList.relocate(180, 90);
        jobRoleList.setPrefSize(150, 85);

        // Populate ListView with companies
        companyList = new ListView<>();
        String[] companies = {"Apple", "Bell", "IBM", "Meta", "Amazon", "Google"};
        companyList.setItems(FXCollections.observableArrayList(companies));
        companyList.relocate(180, 405);
        companyList.setPrefSize(150, 85);
        companyList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); // Enable multi-selection

        jobDescriptionLabel = new Label();
        jobDescriptionLabel.relocate(10, 200);
        jobDescriptionLabel.setPrefSize(500, 100);
        jobDescriptionLabel.setWrapText(true);

        statusLabel = new Label();
        statusLabel.relocate(10, 480);
        statusLabel.setPrefSize(500, 100);

        getChildren().addAll(nameLabel,phoneLabel,jobRoleLabel,skillLabel,viewDetailButton,nameField,phoneField,skillsField,
                companyLabel,jobRoleList,companyList,clearButton,exitButton,submitButton,jobDescriptionLabel,statusLabel);

    }

}
