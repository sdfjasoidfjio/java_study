package oj_java;

import java.util.*;

class Animal {
    public void speak() {
    }
}

class Dog extends Animal {
    public void speak() {
        System.out.println("bark bark");
    }
}

class Cat extends Animal {
    public void speak() {
        System.out.println("meow meow");
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            String type = sc.nextLine();

            Animal animal; // 부모참조
            if (type.equals("DOG")) {
                animal = new Dog();
            } else if (type.equals("CAT")) {
                animal = new Cat();
            } else {
                animal = new Animal();
            }

            animal.speak();
        }
        sc.close();
    }
}