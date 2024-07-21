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

@Controller
public class TaskFormController {

    @Autowired
    private TaskService taskService;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextArea descriptionField;

    @FXML
    private TextField reportedByField;

    @FXML
    private TextField riskField;

    public void handleSave() {
        Task task = new Task();
        task.setDate(datePicker.getValue());
        task.setDescription(descriptionField.getText());
        task.setReportedBy(reportedByField.getText());
        task.setRisk(riskField.getText());
        taskService.saveTask(task);

        Stage stage = (Stage) datePicker.getScene().getWindow();
        stage.close();

    }

    public void handleCancel() {
        Stage stage = (Stage) datePicker.getScene().getWindow();
        stage.close();
    }
}
