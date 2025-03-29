package Exception;

public class Main {
    public static void main(String[] args) {
        try {
            input(10);
        } catch (Under18YearOldException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(" Chương trình kết thúc không có lỗi ");
    }
    public static void input(int age){
        if (age < 18){
            throw new Under18YearOldException("Bạn chưa đủ tuổi");
        }
    }
}
