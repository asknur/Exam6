import java.time.LocalDateTime;
import java.util.UUID;

public class Patient {
    private String id;
    private String fullName;
    private String birthDate;
    private String type;
    private String symptoms;
    private LocalDateTime appointmentTime;

    public Patient(String fullName, String birthDate, String type, String symptoms, LocalDateTime appointmentTime) {
        this.id = UUID.randomUUID().toString();
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.type = type;
        this.symptoms = symptoms;
        this.appointmentTime = appointmentTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalDateTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
}