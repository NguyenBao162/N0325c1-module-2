package ss8_Exception;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Regex {
        // kiểm tra sdt
        private static final String CHECK_SDT_REGEX = "(0|\\+84)3[2-9][0-9]{7}";

        //  kiểm tra email
        private static final String CHECK_EMAIL_REGEX = "[A-Za-z0-9_]{6,32}@[A-Za-z0-9]{2,12}\\.[A-Za-z0-9]{2,12}";

        // kiểm tra username
        private static final String CHECK_USERNAME_REGEX = "[A-Za-z0-9_.]{6,32}";

        // kiểm tra password
        private static final String CHECK_PASSWORD_REGEX = "[A-Z][A-Z a-z 0-9!@#$%^&*().]{6,32}";

        public static boolean validate(String input, String regex) {
            return Pattern.matches(regex, input);
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Kiểm tra số điện thoại
            System.out.print("Nhập số điện thoại: ");
            String phone = scanner.nextLine();
            System.out.println(validate(phone, CHECK_SDT_REGEX) ? "Số điện thoại hợp lệ" : "Số điện thoại không hợp lệ");

            // Kiểm tra email
            System.out.print("Nhập email: ");
            String email = scanner.nextLine();
            System.out.println(validate(email,CHECK_EMAIL_REGEX) ? "Email hợp lệ" : "Email không hợp lệ");

            // Kiểm tra username
            System.out.print("Nhập username: ");
            String username = scanner.nextLine();
            System.out.println(validate(username, CHECK_USERNAME_REGEX) ? "Username hợp lệ" : "Username không hợp lệ");

            // Kiểm tra password
            System.out.print("Nhập password: ");
            String password = scanner.nextLine();
            System.out.println(validate(password, CHECK_PASSWORD_REGEX) ? "Password hợp lệ" : "Password không hợp lệ");

            scanner.close();
        }
    }
