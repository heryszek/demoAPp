package com.qmapp.demo.controller;


import com.qmapp.demo.model.AdverseEvent;
import com.qmapp.demo.model.Task;
import com.qmapp.demo.service.AdverseEventService;
import com.qmapp.demo.service.TaskService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class MainController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private AdverseEventService adverseEventService;

    @FXML
    private VBox contentPane;

    @FXML
    private TableView<Object> tableView;

    private boolean showingTasks = true;

    public void showTasks() {
        showingTasks = true;
        tableView.getItems().setAll(taskService.getAllTasks());
    }

    public void showAdverseEvents() {
        showingTasks = false;
        tableView.getItems().setAll(adverseEventService.getAllAdverseEvents());
    }

    public void addNew() {
        try {
            FXMLLoader loader = new FXMLLoader();
            if (showingTasks) {
                loader.setLocation(getClass().getResource("/fxml/task_form.fxml"));
            } else {
                loader.setLocation(getClass().getResource("/fxml/adverse_event_form.fxml"));
            }

            Parent parent = loader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(parent));
            stage.showAndWait();

            if (showingTasks) {
                showTasks();
            } else {
                showAdverseEvents();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteSelected() {
        Object selectedItem = tableView.getSelectionModel().getSelectedItem();
        if (selectedItem instanceof Task) {
            taskService.deleteTask(((Task) selectedItem).getId());
        } else if (selectedItem instanceof AdverseEvent) {
            adverseEventService.deleteAdverseEvent(((AdverseEvent) selectedItem).getId());
        }
        tableView.getItems().remove(selectedItem);
    }

    public void handleExit() {
        System.exit(0);
    }
}

