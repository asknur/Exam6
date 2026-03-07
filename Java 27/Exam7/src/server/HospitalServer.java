package server;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;

public class HospitalServer extends BasicServer {

    public HospitalServer(String host, int port) throws IOException {
        super(host, port);
        registerGet("/", this::showCalendar);
        registerGet("/day", this::showDay);
        registerGet("/add-patient", this::showAddPatientForm);
        registerPost("/add", this::addPatient);
        registerPost("/delete", this::deletePatient);
        registerGet("/edit-patient", this::showEditPatientForm);
        registerPost("/edit", this::editPatient);
    }


}
