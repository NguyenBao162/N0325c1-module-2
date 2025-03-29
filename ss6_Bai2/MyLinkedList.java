package ss6_Bai2;

public class MyLinkedList<T> {
    private class Node<T> {
        Node next;
        T value;

        public Node(T value) {
            this.value = value;
        }
    }
    private Node head;
    private Node tail;
    private int size = 0;
    // a. thêm đối tượng vào đầu danh sách
    public void addFisrt(T value){
        Node newnode = new Node(value);
        if (head == null){
            head = newnode;
            tail = newnode;
        } else {
            newnode.next = head;
            head = newnode;
        }
        size++;
    }
    //b. xuất thông tin
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node temp = head;
        for (int i = 0; i < size; i++){
            stringBuilder.append(temp.value).append("\t");
            temp = temp.next;
        }
        return stringBuilder.toString();
    }

}
