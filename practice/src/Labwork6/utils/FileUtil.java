package Labwork6.utils;

import Labwork6.models.Truck;
import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtil {
    private static final Gson GSON = new Gson();
    private static final Path PATH = Paths.get("src/Labwork6/data/trucks.json");

    public static Truck[] readFile() {
        try{
            String json = Files.readString(PATH);
            return GSON.fromJson(json, Truck[].class);
        } catch(IOException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return new Truck[3];
        }
    }

    public static void writeFile(Truck[] trucks){
        try{
            String newJson = GSON.toJson(trucks);
            byte[] strToBytes = newJson.getBytes();
            Files.write(PATH, strToBytes);
        } catch(IOException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
