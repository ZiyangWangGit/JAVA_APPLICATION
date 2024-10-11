package com.example.workshop3;

import javafx.collections.FXCollections;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;

public class EmailBuddyPanel extends GridPane {
    private EmailBuddyList model; // This is the list of buddies

    // The components on the window
    private ListView<EmailBuddy> buddyList;
    private Button addButton;
    private Button removeButton;
    private CheckBox hotListButton;

    public ListView<EmailBuddy> getBuddyList() {
        return buddyList;
    }

    public Button getAddButton() {
        return addButton;
    }

    public Button getRemoveButton() {
        return removeButton;
    }

    public CheckBox getHotListButton() {
        return hotListButton;
    }

    public EmailBuddyPanel(EmailBuddyList m) {
        model = m; // Store the model so that the update() method can access it
        setPadding(new Insets(10, 10, 10, 10));

        buddyList = new ListView<>();
        buddyList.setItems(FXCollections.observableArrayList(m.getEmailBuddies()));
        add(buddyList, 0, 0, 1, 3); // spans 1 column, 3 rows
        buddyList.setPrefHeight(Integer.MAX_VALUE);
        buddyList.setMinWidth(200);
        buddyList.setPrefWidth(Integer.MAX_VALUE);

        addButton = new Button("Add");
        add(addButton, 1, 0);
        setMargin(addButton, new Insets(0, 0, 10, 10));
        setValignment(addButton, VPos.TOP);
        setHalignment(addButton, HPos.CENTER);
        addButton.setMinHeight(25);
        addButton.setMinWidth(100);

        removeButton = new Button("Remove");
        add(removeButton, 1, 1);
        setMargin(removeButton, new Insets(0, 0, 10, 10));
        setValignment(removeButton, VPos.TOP);
        setHalignment(removeButton, HPos.CENTER);
        removeButton.setMinHeight(25);
        removeButton.setMinWidth(100);

        hotListButton = new CheckBox("Show Hot List");
        add(hotListButton, 1, 2);
        setMargin(hotListButton, new Insets(0, 0, 10, 10));
        setValignment(hotListButton, VPos.TOP);
        setHalignment(hotListButton, HPos.CENTER);
        hotListButton.setMinHeight(25);
        hotListButton.setMinWidth(100);

        // Now update the components by filling them in
        update();
    }

    // Update the components so that they reflect the contents of the model
    public void update() {
        // Remember what was selected
        int selectedItem = buddyList.getSelectionModel().getSelectedIndex();

        // Now re-populate the list by creating and returning a new array
        EmailBuddy[] exactList;
        if (hotListButton.isSelected()) {
            exactList = new EmailBuddy[model.getHotListSize()];
            for (int i = 0; i < model.getHotListSize(); i++) {
                exactList[i] = model.getHotListBuddy(i);
            }
        } else {
            exactList = new EmailBuddy[model.getSize()];
            for (int i = 0; i < model.getSize(); i++) {
                exactList[i] = model.getBuddy(i);
            }
        }

        buddyList.setItems(null); // Seems to be required for a proper update
        buddyList.setItems(FXCollections.observableArrayList(exactList));

        // Reselect the selected item
        buddyList.getSelectionModel().select(selectedItem);

        // Enable/disable the Remove button accordingly
        removeButton.setDisable(buddyList.getSelectionModel().getSelectedIndex() < 0);
    }
}
