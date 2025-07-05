import java.time.LocalDate;
import java.util.*;

public class Schedule {
    private final Map<LocalDate, List<Patient>> appointments = new HashMap<>();

    public void addPatient(Patient patient) {
        LocalDate date = patient.getAppointmentTime().toLocalDate();
        appointments.computeIfAbsent(date, k -> new ArrayList<>()).add(patient);
    }

    public void removePatient(String id) {
        appointments.values().forEach(list -> list.removeIf(p -> p.getId().equals(id)));
    }

    public List<Patient> getPatientsByDate(LocalDate date) {
        return appointments.getOrDefault(date, Collections.emptyList());
    }
}
