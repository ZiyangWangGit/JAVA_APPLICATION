package com.example.workshop3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Dialog;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

import java.util.Optional;

public class EmailBuddyApp extends Application {
    private EmailBuddyList model; // The model
    private EmailBuddyPanel view; // The view

    @Override
    public void start(Stage primaryStage) {
        // Initialize the model with no buddies initially
        model = new EmailBuddyList();

        // Create a new viewing panel and add it to the scene
        view = new EmailBuddyPanel(model);

        // Handle the Add buttonCA
        view.getAddButton().setOnAction((ActionEvent actionEvent) -> {
            EmailBuddy aBuddy = new EmailBuddy(); // Create a new EmailBuddy
            Dialog<EmailBuddy> dialog = new BuddyDetailsDialog(primaryStage, "New Buddy Details", aBuddy);
            Optional<EmailBuddy> result = dialog.showAndWait();
            if (result.isPresent()) {
                model.add(aBuddy); // Add the buddy to the model
                view.update();     // Refresh the view to reflect changes
            }
        });

        // Handle the Remove button
        view.getRemoveButton().setOnAction((ActionEvent actionEvent) -> {
            int index = view.getBuddyList().getSelectionModel().getSelectedIndex();
            if (index >= 0) {
                model.remove(index); // Remove the selected buddy from the model
                view.update();       // Refresh the view to reflect changes
            }
        });

        // Handle the Hot List Button
        view.getHotListButton().setOnAction((ActionEvent actionEvent) -> {
            view.update(); // Update the view to show the hot list
        });

        // Handle a double-click in the list to edit a buddy
        view.getBuddyList().setOnMousePressed((MouseEvent mouseEvent) -> {
            if (mouseEvent.getClickCount() == 2) {
                int selectedIndex = view.getBuddyList().getSelectionModel().getSelectedIndex();
                if (selectedIndex >= 0) {
                    EmailBuddy selectedBuddy;
                    if (view.getHotListButton().isSelected()) {
                        selectedBuddy = model.getHotListBuddy(selectedIndex);
                    } else {
                        selectedBuddy = model.getBuddy(selectedIndex);
                    }

                    if (selectedBuddy != null) {
                        Dialog<EmailBuddy> dialog = new BuddyDetailsDialog(primaryStage, "Edit Buddy Details", selectedBuddy);
                        Optional<EmailBuddy> result = dialog.showAndWait();
                        if (result.isPresent()) {
                            view.update(); // Refresh the view after editing
                        }
                    }
                }
            }
            else{
                view.update();
            }
        });

        // Set up the stage with a title and the scene
        primaryStage.setTitle("Email Buddy App");
        primaryStage.setScene(new Scene(view, 400, 300));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
