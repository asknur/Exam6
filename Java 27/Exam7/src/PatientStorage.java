import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.Patient;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class PatientStorage {
    private static final Path PATH = Paths.get("data/patients.json");
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static List<Patient> read() {
        try {
            if (Files.notExists(PATH)) return new ArrayList<>();
            String json = Files.readString(PATH);
            Patient[] arr = GSON.fromJson(json, Patient[].class);
            return new ArrayList<>(Arrays.asList(arr));
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static void write(List<Patient> patients) {
        try {
            String json = GSON.toJson(patients);
            Files.write(PATH, json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}