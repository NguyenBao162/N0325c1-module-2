package ss3_Bai3;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        String stringDate1 = "22/03/2025";
        String stringDate2 = "2025/07/22";

        LocalDate date1 = LocalDateUtil.fromString_ddMMyyyy(stringDate1);
        LocalDate date2 = LocalDateUtil.fromString_yyyyMMdd(stringDate2);

        System.out.println("LocalDate from string dd/MM/yyyy: " + date1);
        System.out.println("LocalDate from string yyyy/MM/dd: " + date2);

        LocalDate currentDate = LocalDate.now();


        String formattedDate1 = LocalDateUtil.toString_ddMMyyyy(currentDate);
        String formattedDate2 = LocalDateUtil.toString_yyyyMMdd(currentDate);

        System.out.println("String form LocalDate (dd/MM/yyyy): " + formattedDate1);
        System.out.println("String form LocalDate (yyyy/MM/dd): " + formattedDate2);
    }
}

