package models;

import java.time.LocalDateTime;

public class Patient {
    private int id;
    private String fullName;
    private String birthday;
    private String type;
    private String symptom;
    private LocalDateTime appointmentTime;

    public Patient(int id, String fullName, String birthday, String type, String symptom, LocalDateTime appointmentTime) {
        this.id = id;
        this.fullName = fullName;
        this.birthday = birthday;
        this.type = type;
        this.symptom = symptom;
        this.appointmentTime = appointmentTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalDateTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
}
