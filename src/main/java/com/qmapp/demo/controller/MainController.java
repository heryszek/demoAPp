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
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class MainController {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private TaskService taskService;

    @Autowired
    private AdverseEventService adverseEventService;

    @Autowired
    private ApplicationContext applicationContext;

    @FXML
    private VBox contentPane;

    @FXML
    private TableView<Object> tableView;

    private boolean showingTasks = true;

    @FXML
    public void initialize() {
        showTasks();
    }

    public void showTasks() {
        showingTasks = true;
        refreshTable();
    }

    public void showAdverseEvents() {
        showingTasks = false;
        refreshTable();
    }

    public void addNew() {
        try {
            FXMLLoader loader = new FXMLLoader();
            if (showingTasks) {
                loader.setLocation(getClass().getResource("/fxml/task_form.fxml"));
            } else {
                loader.setLocation(getClass().getResource("/fxml/adverse_event_form.fxml"));
            }

            loader.setControllerFactory(applicationContext::getBean);

            Parent parent = loader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(parent));
            stage.showAndWait();

            refreshTable();
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

    private void refreshTable() {
        if (showingTasks) {
            logger.info("Refreshing tasks table");
            tableView.getItems().setAll(taskService.getAllTasks());
            logger.info("Number of tasks loaded: " + taskService.getAllTasks().size());
        } else {
            logger.info("Refreshing adverse events table");
            tableView.getItems().setAll(adverseEventService.getAllAdverseEvents());
            logger.info("Number of adverse events loaded: " + adverseEventService.getAllAdverseEvents().size());
        }
    }
}
