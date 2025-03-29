package ss8_File;

import java.io.File;
import java.io.IOException;

public class Bai1E {
    public static void main(String[] args) throws IOException { // path là đường dẫn cần xóa
        String path = "?";
        File fileToDelete = new File(path);
        if (fileToDelete.exists()) {
            if (fileToDelete.delete()) {
                System.out.println("Đã xóa thành công:" + path);
            } else {
                System.out.println("Không thể xóa: " + path);
            }
            } else{
                System.out.println("Đường dẫn không tồn tại:" + path);
            }
        }
    }
