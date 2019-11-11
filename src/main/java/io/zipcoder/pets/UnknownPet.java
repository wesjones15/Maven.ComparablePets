package io.zipcoder.pets;

import io.zipcoder.Console;
import io.zipcoder.Pet;

public class UnknownPet extends Pet {
    public UnknownPet(String name, String type) {
        super(name, type);
    }

    public String speak() {
        String sound = String.format("(%s noises)!", getType());
        Console.println(sound);
        return sound;
    }
}
