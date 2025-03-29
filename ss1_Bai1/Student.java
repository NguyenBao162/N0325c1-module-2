package ss1_Bai1;

import java.util.Scanner;

public class Student {
    String name;
    double mathScore;
    double literatureScore;

    void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào tên học sinh: ");
        name = scanner.nextLine();
        System.out.print("Nhập vào Điểm Toán: ");
        mathScore = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập vào Điểm Văn: ");
        literatureScore = Double.parseDouble(scanner.nextLine());
    }

    double calAverageScore() {
        return (mathScore + literatureScore) / 2;
    }

    void outputData() {
        System.out.println("Học Sinh tên:" + name);
        System.out.println("Điểm Toán là: " + mathScore);
        System.out.println("Điểm Văn là: " + literatureScore);
        System.out.println("Điểm trung bình:" + calAverageScore());
    }
}
