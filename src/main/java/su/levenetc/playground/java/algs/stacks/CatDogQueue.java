package su.levenetc.playground.java.algs.stacks;

import java.util.LinkedList;

public class CatDogQueue {

    LinkedList<Cat> catList = new LinkedList<>();
    LinkedList<Dog> dogList = new LinkedList<>();
    int order = 0;

    public void enqueue(Animal animal) {
        animal.order = order++;

        if (animal instanceof Cat) {
            catList.add((Cat) animal);
        } else {
            dogList.add((Dog) animal);
        }
    }

    public boolean isEmpty() {
        return catList.isEmpty() && dogList.isEmpty();
    }

    public Animal dequeueAny() {

        if (isEmpty()) {
            return null;
        } else if (catList.isEmpty()) {
            return dogList.poll();
        } else if (dogList.isEmpty()) {
            return catList.poll();
        } else {

            if (catList.peek().order < dogList.peek().order) {
                return catList.poll();
            } else {
                return dogList.poll();
            }
        }
    }

    public Animal dequeueCat() {
        if (catList.isEmpty()) {
            return null;
        } else {
            return catList.poll();
        }
    }

    public Animal dequeueDog() {
        if (dogList.isEmpty()) {
            return null;
        } else {
            return dogList.poll();
        }
    }

    public static class Animal {
        int order;
        String name;

        public Animal(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null) return false;
            if (obj.getClass() != getClass()) return false;
            return ((Animal) obj).name.equals(name);
        }

        @Override
        public String toString() {
            return String.format("{name:%s, order:%d}", name, order);
        }
    }

    public static class Dog extends Animal {

        public Dog(String name) {
            super(name);
        }
    }

    public static class Cat extends Animal {

        public Cat(String name) {
            super(name);
        }
    }
}
