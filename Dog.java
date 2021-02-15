package ru.geekbrains.lesson1.work6;

public class Dog extends Animal {
    public static int objectDogCount;

    public Dog(String name) {
        super(name);
        swimmingRestrictions = 10;
        runningRestrictions = 500;
        heightJump = 2;
        objectDogCount++;
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
    public void swim(int swimDistance) {
        if (swimDistance > swimmingRestrictions) {
            System.out.printf("%s проплыть %d м не может.\n", name, swimDistance);
        } else {
            System.out.printf("%s проплыл %d м.\n", name, swimDistance);
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
}

