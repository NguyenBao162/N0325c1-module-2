package ss5_demo;

public class Main {
    public static void main(String[] args) {
        Cat c1 = new Cat("Hello");
        Cat c2 = new Cat("Hello");
        System.out.println(c1.equals(c2));

        Animal [] animals = new Animal[2];
        animals[0] = new Cat("Meo meo");
        animals[1] = new Dog();

        for(Animal animal : animals) { // animal = dog
            if(animal instanceof Cat) {
                ((Cat) animal).run(); // Mèo chạy
            }
            animal.tiengKeu(); // Meo Meo
        }
    }
}
