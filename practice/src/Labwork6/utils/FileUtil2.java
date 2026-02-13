package Labwork6.utils;

import Labwork6.models.Driver;
import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtil2 {
    private static final Gson GSON = new Gson();
    private static final Path PATH = Paths.get("src/Labwork6/data/drivers.json");

    public static Driver[] readFile() {
        try{
            String json = Files.readString(PATH);
            return GSON.fromJson(json, Driver[].class);
        } catch(IOException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return new Driver[3];
        }
    }

    public static void writeFile(Driver[] drivers){
        try{
            String newJson = GSON.toJson(drivers);
            byte[] strToBytes = newJson.getBytes();
            Files.write(PATH, strToBytes);
        } catch(IOException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
