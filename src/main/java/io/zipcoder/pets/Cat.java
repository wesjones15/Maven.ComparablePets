package io.zipcoder.pets;

import io.zipcoder.Console;
import io.zipcoder.Pet;

public class Cat extends Pet {
    public Cat(String name) {
        super(name, "cat");
    }
    public String speak() {
        String sound = "meow!";
        Console.println(sound);
        return sound;
    }
}
