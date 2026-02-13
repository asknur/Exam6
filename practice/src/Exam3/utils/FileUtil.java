package Exam3.utils;

import Exam3.Models.Commodity;
import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtil {
    private static final Gson GSON = new Gson();
    private final Path PATH;

    public FileUtil(String fileName) {
        this.PATH = Paths.get(fileName);
    }


    public static Commodity[] readFile(FileUtil fileUtil) {
        try {
            String json = Files.readString(fileUtil.PATH);
            return GSON.fromJson(json, Commodity[].class);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return new Commodity[5];
        }
    }

    public static void writeFile(Commodity[] trucks, Path PATH) {
        try {
            String newJson = GSON.toJson(trucks);
            byte[] strToBytes = newJson.getBytes();
            Files.write(PATH, strToBytes);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    public void getGoods() {
        System.out.println("[\n" +
                "  {\n" +
                "    \"id\": \"C001\",\n" +
                "    \"name\": \"Laptop\",\n" +
                "    \"price\": 1200.50,\n" +
                "    \"honorary_code\": 101,\n" +
                "    \"state\": \"in_stock\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"C002\",\n" +
                "    \"name\": \"Smartphone\",\n" +
                "    \"price\": 850.99,\n" +
                "    \"honorary_code\": 102,\n" +
                "    \"state\": \"for_sale\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"C003\",\n" +
                "    \"name\": \"Headphones\",\n" +
                "    \"price\": 150.75,\n" +
                "    \"honorary_code\": 103,\n" +
                "    \"state\": \"sold\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"C004\",\n" +
                "    \"name\": \"Monitor\",\n" +
                "    \"price\": 320.00,\n" +
                "    \"honorary_code\": 104,\n" +
                "    \"state\": \"in_stock\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"C005\",\n" +
                "    \"name\": \"Keyboard\",\n" +
                "    \"price\": 75.25,\n" +
                "    \"honorary_code\": 105,\n" +
                "    \"state\": \"for_sale\"\n" +
                "  }\n" +
                "]\n");
    }
}

