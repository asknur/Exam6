import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

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

    public List<Patient> getAllPatients() {
        return appointments.values().stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public void updatePatient(String id, String type, String symptoms, LocalDateTime time) {
        for (List<Patient> list : appointments.values()) {
            for (Patient p : list) {
                if (p.getId().equals(id)) {
                    list.remove(p);
                    p.setType(type);
                    p.setSymptoms(symptoms);
                    p.setAppointmentTime(time);
                    addPatient(p);
                    return;
                }
            }
        }
    }

}
