import com.sun.net.httpserver.HttpExchange;
import kg.attractor.java.lesson44.Lesson44Server;
import freemarker.template.*;
import java.io.*;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.stream.Collectors;

public class HospitalServer extends Lesson44Server {
    private final Schedule schedule = new Schedule();
    private final Configuration freemarker;

    public HospitalServer(String host, int port) throws IOException {
        super(host, port);
        this.freemarker = initFreeMarker();
        initHandlers();
    }

    private void initHandlers() {
        registerGet("/", this::showCalendar);
        registerGet("/day", this::showDay);
        registerGet("/add-patient", this::showAddPatientForm);
        registerPost("/add", this::addPatient);
        registerPost("/delete", this::deletePatient);
    }

    private void showCalendar(HttpExchange exchange) throws IOException {
        LocalDate today = LocalDate.now();
        Map<String, Object> data = new HashMap<>();
        data.put("today", today);
        data.put("schedule", schedule);
        renderTemplate(exchange, "calendar.ftlh", data);
    }

    private void showDay(HttpExchange exchange) throws IOException {
        String dateStr = getQueryParams(exchange).get("date");
        LocalDate date = LocalDate.parse(dateStr);

        List<Patient> patients = schedule.getPatientsByDate(date).stream().sorted(Comparator.comparing(Patient::getAppointmentTime))
                .collect(Collectors.toList());
        Map<String, Object> data = new HashMap<>();
        data.put("date", date);
        data.put("patients", patients);
        renderTemplate(exchange, "day.ftlh", data);
    }

    private void showAddPatientForm(HttpExchange exchange) throws IOException {
        String dateStr = getQueryParams(exchange).get("date");
        if (dateStr == null) {
            renderError(exchange, "Не указана дата для записи");
            return;
        }
        Map<String, Object> data = new HashMap<>();
        data.put("date", dateStr);
        renderTemplate(exchange, "add-patient.ftlh", data);
    }

    private void addPatient(HttpExchange exchange) throws IOException {
        Map<String, String> form = parseFormData(exchange);
        LocalDateTime time = LocalDateTime.parse(form.get("time"));
        if (time.isBefore(LocalDateTime.now())) {
            renderError(exchange, "Нельзя записаться на прошедшую дату");
            return;
        }
        Patient patient = new Patient(form.get("name"), form.get("birthdate"), form.get("type"), form.get("symptoms"), time);
        schedule.addPatient(patient);
        redirect303(exchange, "/day?date=" + time.toLocalDate());
    }

    private void deletePatient(HttpExchange exchange) throws IOException {
        try {
            Map<String, String> formData = parseFormData(exchange);
            String id = formData.get("id");
            String date = formData.get("date");

            if (id == null || id.isEmpty()) {
                renderError(exchange, "Нет ID");
                return;
            }
            schedule.removePatient(id);
            redirect303(exchange, "/day?date=" + date);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Configuration initFreeMarker() throws IOException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
        cfg.setDirectoryForTemplateLoading(new File("data"));
        cfg.setDefaultEncoding("UTF-8");
        return cfg;
    }
}