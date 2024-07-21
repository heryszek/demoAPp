package com.qmapp.demo.model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class AdverseEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private String description;
    private String reportedBy;
    private String risk;

    public AdverseEvent() {
    }

    public AdverseEvent(LocalDate date, String description, String reportedBy, String risk) {
        this.date = date;
        this.description = description;
        this.reportedBy = reportedBy;
        this.risk = risk;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getReportedBy() {
        return reportedBy;
    }

    public String getRisk() {
        return risk;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReportedBy(String reportedBy) {
        this.reportedBy = reportedBy;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }

    @Override
    public String toString() {
        return "AdverseEvent{" +
               "id=" + id +
               ", date=" + date +
               ", description='" + description + '\'' +
               ", reportedBy='" + reportedBy + '\'' +
               ", risk='" + risk + '\'' +
               '}';
    }
    // Getters and Setters
}
