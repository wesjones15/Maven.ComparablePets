package io.zipcoder.pets;

import io.zipcoder.Console;
import io.zipcoder.Pet;

public class Bird extends Pet {
    public Bird(String name) {
        super(name, "bird");
    }
    public String speak() {
        String sound = "chirp!";
        Console.println(sound);
        return sound;
    }
}

