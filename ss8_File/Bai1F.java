package ss8_File;

import java.io.File;
import java.io.IOException;

public class Bai1F {
    public static void main(String[] args) throws IOException {
        String oldPath = "?";
        String newPath = "?";
        File oldFileOrDirectory = new File(oldPath);
        File newFileOrDirectory = new File(newPath);
        if (oldFileOrDirectory.exists()) {
            if (oldFileOrDirectory.renameTo(newFileOrDirectory)) {
                System.out.println("Đã đổi tên thành công.");
        } else {
            System.out.println("Không thể đổi tên.");
        }
    } else {
            System.out.println("Tệp không tồn tại");
        }
    }
}
