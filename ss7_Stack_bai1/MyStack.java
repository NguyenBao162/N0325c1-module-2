package ss7_Stack_bai1;


public class MyStack<E> {
    private class Node{
        private E value;
        private Node next;

        public Node(E value){ this.value = value; }
    }
    private Node head;
    private Node tail;

    private int size;

    //push:
    public void push(E value){
        Node newNode = new Node(value);
        if (head == null){
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    // peek
    public E peek() {
        if (head == null){
            return null;
        }
        return head.value;
    }

    //pop
    public E pop(){
        if (head == null){
            return null;
        }
        Node temp = head;
        if (size == 1){
            head = null;
            tail = null;
        } else {
                head = head.next;
        }
        size--;
        return temp.value;
    }

    //isEmpty
    public boolean isEmpty() {return size == 0;}

    //size ..trả về sl ptử
    public int size() {return size;}

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        Node temp  = head;
        for (int i = 0; i < size; i ++ ){
            stringBuilder.append(temp.value).append("\t");
            temp = temp.next;
        }
        return stringBuilder.toString();
    }

}

