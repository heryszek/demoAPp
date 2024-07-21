package com.qmapp.demo.controller;

import com.qmapp.demo.model.Task;
import com.qmapp.demo.service.TaskService;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class TaskFormController {

    private static final Logger logger = LoggerFactory.getLogger(TaskFormController.class);

    private final TaskService taskService;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextArea descriptionField;

    @FXML
    private TextField reportedByField;

    @FXML
    private TextField riskField;

    @Autowired
    public TaskFormController(TaskService taskService) {
        this.taskService = taskService;
    }

    @FXML
    public void handleSave() {
        Task task = new Task();
        task.setDate(datePicker.getValue());
        task.setDescription(descriptionField.getText());
        task.setReportedBy(reportedByField.getText());
        task.setRisk(riskField.getText());

        logger.info("Task details:");
        logger.info("Date: " + task.getDate());
        logger.info("Description: " + task.getDescription());
        logger.info("Reported By: " + task.getReportedBy());
        logger.info("Risk: " + task.getRisk());

        taskService.saveTask(task);
        close();
    }

    @FXML
    public void handleCancel() {
        close();
    }

    private void close() {
        Stage stage = (Stage) datePicker.getScene().getWindow();
        stage.close();
    }
}



