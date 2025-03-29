package ss8_Exception;

import java.util.Scanner;

public class ChuongTrinh {

    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String sdt ;
    while (true){
        System.out.println(" mời bạn nhập sdt");
        sdt = scanner.nextLine();

        if (sdt.matches("03[2-9][0-9]{7}")){
            System.out.println("bạn đã nhập đúng mẫu số điện thoại");
            break;
        } else {
            System.out.println("bạn đã nhập sai mẫu, xin vui lòng thử lại");
        }
    }
    scanner.close();
    }
}




