package ss7_Stack_bai1;

public class Main {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();

        //a. push
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println("Ngăn xếp:\n" + stack.toString()); // in ra 40 30 20 10

        // b. peek
        Integer peekValue = stack.peek();
        System.out.println("Giá trị ở đầu ngăn xếp: " + peekValue); // in ra 40

        //c.pop
        Integer popValue = stack.pop();
        System.out.println("Giá trị lấy ra " + popValue );

        //d. isempty
        boolean isEmpty = stack.isEmpty();
        System.out.println("Ngăn xếp có trống không " + isEmpty);

        //e. size
        int  stackSize = stack.size();
        System.out.println("kích thước ngăn xếp " + stackSize);
    }
}
