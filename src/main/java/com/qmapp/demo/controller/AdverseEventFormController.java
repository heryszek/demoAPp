package com.qmapp.demo.controller;

import com.qmapp.demo.model.AdverseEvent;
import com.qmapp.demo.service.AdverseEventService;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AdverseEventFormController {

    @Autowired
    private AdverseEventService adverseEventService;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextArea descriptionField;

    @FXML
    private TextField reportedByField;

    @FXML
    private TextField riskField;

    public void handleSave() {
        AdverseEvent adverseEvent = new AdverseEvent();
        adverseEvent.setDate(datePicker.getValue());
        adverseEvent.setDescription(descriptionField.getText());
        adverseEvent.setReportedBy(reportedByField.getText());
        adverseEvent.setRisk(riskField.getText());
        adverseEventService.saveAdverseEvent(adverseEvent);

        Stage stage = (Stage) datePicker.getScene().getWindow();
        stage.close();
    }

    public void handleCancel() {
        Stage stage = (Stage) datePicker.getScene().getWindow();
        stage.close();
    }
}

