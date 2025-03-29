package ss5_demo;

import java.util.Objects;

public class Cat extends Animal implements Flyable {
    private String name = "Meo Meo";
//    @Override
    void tiengKeu() {
        System.out.println("Meo meo");
    }
    void run() {
        System.out.println("Mèo chạy");
    }

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Objects.equals(name, cat.name);
    }

    @Override
    public void fly() {
        System.out.println("Meo co the bay");
    }
}
