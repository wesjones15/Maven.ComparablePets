package io.zipcoder;

import java.util.Comparator;

public class SortPets implements Comparator<Pet> {
    public int compare(Pet pet1, Pet pet2) {
        return (!pet1.getType().equals(pet2.getType())) ?
                pet1.getType().compareToIgnoreCase(pet2.getType()) :
                pet1.getName().compareToIgnoreCase(pet2.getName());
    }
}
