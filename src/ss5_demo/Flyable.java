package ss5_demo;

public interface Flyable {
    int MAX = 100;
    void fly();

    default void fly2() {
        System.out.println("Oke");
    }
    /*
    interface I
    100 class -> I
     */

    static void fly3() {
        System.out.println("Oke");
    }
}
