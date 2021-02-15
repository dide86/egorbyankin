package ru.geekbrains.lesson1.work6;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Бобик");
        Animal cat = new Cat("Барсик");
        Cat cat2 = new Cat("Сёма");
        dog.run(10);
        cat.run(10);
        cat.swim(1);
        dog.swim(50);
        cat2.run(10);
        cat2.jump(2);
        dog.jump(1);
    }
}
