package util;

import org.testng.annotations.Test;

import java.util.Random;

import static org.apache.fontbox.afm.AFMParser.CHARACTERS;

public class RandomUtil {

    private static String num = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";

    public static String randomString(int length){
    Random random = new Random();
    StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
        int index = random.nextInt(num.length());
        sb.append(num.charAt(index)); // Add random character
    }
        return sb.toString();
}

}
