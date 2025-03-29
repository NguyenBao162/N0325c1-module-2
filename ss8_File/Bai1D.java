package ss8_File;

import java.io.File;
import java.io.IOException;

public class Bai1D {
    public static void main(String[] args) throws IOException {
        // path là đường dẫn cần kiểm tra
        String path = "";
        File file = new File(path);
        if (file.exists()) {
            if (file.isFile()) {
                System.out.println("Đường dẫn trỏ đến một tệp.");
            } else if (file.isDirectory()) {
                System.out.println("Đường dẫn trỏ đến một thư mục.");
            } else {
                System.out.println("Đường dẫn tồn tại nhưng không phải là tệp hoặc thư mục.");
            }
        } else {
            System.out.println("Đường dẫn không tồn tại.");
        }
    }
}
