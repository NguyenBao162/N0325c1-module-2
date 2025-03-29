package ss8_Exception;

public class Main {
    public static void main(String[] args) {
        try {
            int[] arr = {10, 20, 30};
            System.out.println(arr[100]);
            String str = null;
            str.equals("Hello");
            System.out.println("ở trong khoi try");
        } catch (NullPointerException e) {
            System.out.println("lỗi tham chiếu đến Null");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(" lỗi index ngoài mảng");
        }
        System.out.println("Chuong trình không có lỗi");
    }
}
