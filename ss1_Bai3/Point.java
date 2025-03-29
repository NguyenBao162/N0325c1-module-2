package ss1_Bai3;

import java.util.Scanner;
import java.awt.*;
public class Point {
    private double x;
    private double y;

    void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tọa độ x: ");
        x = scanner.nextDouble();

        System.out.print("Nhập tọa độ y: ");
        y = scanner.nextDouble();
    }

    double distanceTo(Point other) {
        double dx = other.x - this.x;
        double dy = other.y - this.y;
        double distance = Math.sqrt(dx * dx + dy * dy);
        return distance;
    }
}

