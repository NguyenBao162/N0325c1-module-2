package ss8_File;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Bai1C {
    public static void main(String[] args) throws IOException {
        File file = new File("?");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String targetWord = "Hoàng";
        String line;
        int count = 0;
        while ((line = bufferedReader.readLine()) != null) {
            if (line.equals(targetWord)) {
                count++;
            }
        }
        System.out.println("Số lần xuất hiện của từ '" + targetWord + "': " + count);
        bufferedReader.close();
    }
}
