package ru.geekbrains.lesson1.work6;

abstract class Animal {
    protected int runningRestrictions;
    protected int swimmingRestrictions;
    protected int heightJump;
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void run(int runDistance);
    public abstract void swim(int swimDistance);
    public abstract void jump(int height);
}


