import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            new HospitalServer("localhost", 9889).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}