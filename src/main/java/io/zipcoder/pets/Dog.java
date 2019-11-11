package io.zipcoder.pets;

import io.zipcoder.Console;
import io.zipcoder.Pet;

public class Dog extends Pet {
    public Dog(String name) {
        super(name, "dog");
    }
    public String speak() {
        String sound = "woof!";
        Console.println(sound);
        return sound;
    }
}
