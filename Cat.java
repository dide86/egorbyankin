package ru.geekbrains.lesson1.work6;

public class Cat extends Animal {
    private static int objectCatCount;

    public Cat(String name) {
        super(name);
        swimmingRestrictions = 0;
        runningRestrictions = 200;
        heightJump = 3;
        objectCatCount++;
    }

    @Override
    public void run(int runDistance) {
        if (runDistance > runningRestrictions) {
            System.out.printf("%s пробежать %d м не может.\n", name, runDistance);
        } else {
            System.out.printf("%s пробежал %d м.\n", name, runDistance);
        }
    }

    @Override
    public void jump(int height) {
        if (height <= heightJump) {
            System.out.printf("%s прыгнул %d м.\n", name, height);
        } else {
            System.out.printf("%s не может прыгнуть %d м.\n", name, height);
        }
    }
    @Override
    public void swim(int swimDistance) {
        System.out.println("Коты плавать не умеют.");
    }
}
