package ss8_Map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bai1B {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Bảo", "Khang", "Khôi", "Ngọc", "Ngà ", "Châu", "Báu");
        // Tạo một Map để lưu trữ số lần xuất hiện của từng tên
        Map<String, Integer> nameCount = new HashMap<>();
        // Duyệt qua danh sách tên và đếm số lần xuất hiện
        for (String name : names) {
            // Nếu name đã tồn tại trong Map, thì giá trị đếm của nó tăng lên 1;
            // Nếu name chưa tồn tại, thì giá trị đếm của nó được đặt thành 1.
            nameCount.put(name, nameCount.getOrDefault(name, 0) + 1);
        }
        // Hiển thị tên duy nhất và tên xuất hiện nhiều lần
        System.out.println("Tên duy nhất:");
        for (
                String name : nameCount.keySet()) {
            if (nameCount.get(name) == 1) {
                System.out.println(name);
            }
        }
        System.out.println("Tên xuất hiện nhiều lần:");
        for (
                String name : nameCount.keySet()) {
            if (nameCount.get(name) > 1) {
                System.out.println(name);
            }
        }
    }
}