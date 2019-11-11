package io.zipcoder;

import io.zipcoder.pets.*;

import java.util.Collections;

public class PetWarehouse {
    private Pet[] pets;

    public PetWarehouse(Pet... pets) {
        this.pets = pets;
    }
    public PetWarehouse(Integer numberOfPets, String[] petTypes, String[] petNames) {
        this.pets = createPets(numberOfPets, petTypes, petNames);
    }

    public Pet[] createPets(Integer numberOfPets, String[] petTypes, String[] petNames) {
        Pet[] pets = new Pet[numberOfPets];
        for (int i = 0; i < numberOfPets; i++) {
            pets[i] = createPetFromType(petTypes[i], petNames[i]);
        }
        return pets;
    }

    public Pet createPetFromType(String petType, String petName) {
        Pet pet;
        if (petType.equals("dog")) {
            pet = new Dog(petName);
        }
        else if (petType.equals("cat")) {
            pet = new Cat(petName);
        }
        else if (petType.equals("bird")) {
            pet = new Bird(petName);
        }
        else if (petType.equals("snake")) {
            pet = new Snake(petName);
        }
        else {
            pet = new UnknownPet(petName, petType);
        }
        return pet;
    }

    public Pet[] getPets() {
        return this.pets;
    }

    public String displayPetInfo() {
        StringBuilder info = new StringBuilder();
        info.append(String.format("You have %s pets.", pets.length));
        for (int i = 0; i < pets.length; i++) {
            info.append(String.format("\nPet %s is a %s named %s.\n", i+1, pets[i].getType(), pets[i].getName()));
            info.append(pets[i].speak());
        }
        Console.println(info.toString());
        return info.toString();
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (Pet pet: this.pets) {
            output.append(String.format("%s\t%s\t%s\n", pet.getType(), pet.getName(), pet.speak()));
        }
        return output.toString();
    }
}

