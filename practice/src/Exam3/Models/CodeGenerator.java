package Exam3.Models;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CodeGenerator {
    Commodity commodity;

    public String makeCode(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return convertToString(md.digest(input.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    private String convertToString(byte[] array) {
        return IntStream.range(0, array.length / 4)
                .map(i -> array[i])
                .map(i -> (i < 0) ? i + 127 : i)
                .mapToObj(Integer::toHexString)
                .collect(Collectors.joining());
    }

    public void setCode(Commodity commodity) {
        if (commodity.getPrice() >= 1000) {
            commodity.setHonorary_code(makeCode("Gold-" + commodity.getId()));
        } else if (commodity.getPrice() >= 500 || commodity.getPrice() < 1000) {
            commodity.setHonorary_code(makeCode("Silver-" + commodity.getId()));
        } else if (commodity.getPrice() < 500) {
            commodity.setHonorary_code(makeCode("Bronze-" + commodity.getId()));
        }
    }


}
