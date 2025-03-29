package ss7_Stack_bai2;

public class Main {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
// a. Thêm phần tử vào hàng đợi queue.add(10);
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        System.out.println("Hàng đợi:" + queue.toString()); // In ra: Hàng đợi: 50
        // b. Lấy ra phần tử đầu tiên mà không xóa nó
        Integer peekValue = queue.peek();
        System.out.println("Giá trị ở đầu hàng đợi: " + peekValue); // In ra: Giá trị ở đầu hàng đợi: 10
        // c. Lấy ra và xóa phần tử đầu tiên
        Integer polledValue = queue.poll();
        System.out.println("Giá trị lấy ra:" + polledValue); // In ra: Giá trị lấy ra: 10
        // d. Kiểm tra xem hàng đợi có trồng không
        boolean isEmpty = queue.isEmpty();
        System.out.println("Hàng đợi có trống không:" + isEmpty); // In ra: Hàng đợi có trống không: fals
        // e. Lấy kích thước của hàng đợi
        int queueSize = queue.size();
        System.out.println("Kích thước hàng đợi: " + queueSize); // In ra: Kích thước hàng đợi: 2
    }
}
