package ss8_File;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Bai1B {
    public static void main(String[] args) throws IOException {
        File file = new File(  "?"); FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        int count = 0;
        while ((line = bufferedReader.readLine()) != null && count++ < 3) { System.out.println(line);
        }
        bufferedReader.close();
    }
}
