package ss2_Bai3;

public class Main {
    public static void main(String[] args) {
        StudentBaoDong student1 = new StudentBaoDong(12, "Nguyễn Bảo", 9.5);


        System.out.println("Thông tin ban đầu: ");
        System.out.println("ID: " + student1.getId());
        System.out.println("Tên: " + student1.getName());
        System.out.println("Điểm: " + student1.getScore());

        // cập nhật
        student1.setName("Nguyễn Bảo");
        student1.setScore(10);

        System.out.println();
        System.out.println("Thông tin sau khi cập nhật: ");
        System.out.println("ID: " + student1.getId());
        System.out.println("Tên: " + student1.getName());
        System.out.println("Điểm: " + student1.getScore());

        // cập nhật thông tin không hợp lệ
        System.out.println();
        student1.setName("");
        student1.setScore(20);
    }
}

