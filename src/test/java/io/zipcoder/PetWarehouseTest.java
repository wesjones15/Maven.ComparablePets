package io.zipcoder;

import io.zipcoder.pets.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class PetWarehouseTest {
    @Test
    public void testCreatePetFromType1() {
        PetWarehouse house = new PetWarehouse();
        String name = "Tucker";
        String type = "dog";
        Pet pet = house.createPetFromType(type, name);
        Assert.assertTrue(pet instanceof Dog);
    }
    @Test
    public void testCreatePetFromType2() {
        PetWarehouse house = new PetWarehouse();
        String name = "Charlie";
        String type = "cat";
        Pet pet = house.createPetFromType(type, name);
        Assert.assertTrue(pet instanceof Cat);
    }
    @Test
    public void testCreatePetFromType3() {
        PetWarehouse house = new PetWarehouse();
        String name = "Lamar";
        String type = "snake";
        Pet pet = house.createPetFromType(type, name);
        Assert.assertTrue(pet instanceof Snake);
    }
    @Test
    public void testCreatePetFromType4() {
        PetWarehouse house = new PetWarehouse();
        String name = "Annabelle";
        String type = "spider";
        Pet pet = house.createPetFromType(type, name);
        Assert.assertTrue(pet instanceof UnknownPet);
    }

    @Test
    public void testCreatePets() {
        Integer numberOfPets = 4;
        String[] petTypes = {"dog", "cat", "snake", "spider"};
        String[] petNames = {"Tucker", "Charlie", "Lamar", "Annabelle"};
        PetWarehouse house = new PetWarehouse();
        Pet[] pets = house.createPets(numberOfPets, petTypes, petNames);
        Assert.assertEquals(4, pets.length);
        for (int i = 0; i < numberOfPets; i++) {
            Assert.assertEquals(petNames[i], pets[i].getName());
            Assert.assertEquals(petTypes[i], pets[i].getType());
        }
    }

    @Test
    public void testConstructor() {
        Integer numberOfPets = 4;
        String[] petTypes = {"dog", "cat", "snake", "spider"};
        String[] petNames = {"Tucker", "Charlie", "Lamar", "Annabelle"};
        PetWarehouse house = new PetWarehouse(numberOfPets, petTypes, petNames);
        Pet[] pets = house.getPets();
        Assert.assertEquals(4, pets.length);
        for (int i = 0; i < numberOfPets; i++) {
            Assert.assertEquals(petNames[i], pets[i].getName());
            Assert.assertEquals(petTypes[i], pets[i].getType());
        }
    }

    @Test
    public void testDisplayPetInfo() {
        Integer numberOfPets = 4;
        String[] petTypes = {"dog", "cat", "snake", "spider"};
        String[] petNames = {"Tucker", "Charlie", "Lamar", "Annabelle"};
        PetWarehouse house = new PetWarehouse(numberOfPets, petTypes, petNames);
        String actual = house.displayPetInfo();
        String expected = "You have 4 pets.\nPet 1 is a dog named Tucker.\nwoof!\nPet 2 is a cat named Charlie.\nmeow!\nPet 3 is a snake named Lamar.\nslither!\nPet 4 is a spider named Annabelle.\n(spider noises)!";
        Assert.assertEquals(expected, actual);
    }

    @Test   // Sort by type then name
    public void testCompare1() {
        Integer numberOfPets = 9;
        String[] petTypes = {"dog", "dog", "dog", "dog", "cat", "snake", "snake", "snake", "spider"};
        String[] petNames = {"Hank", "Doug", "Lerf", "Tucker", "Charlie", "Lamar", "Fredley", "Kark", "Annabelle"};
        PetWarehouse house = new PetWarehouse(numberOfPets, petTypes, petNames);
        Pet[] pets = house.getPets();
        Arrays.sort(pets, new SortPets());
        String actual = house.toString();
        String expected =
                "cat\tCharlie\tmeow!\n" +
                "dog\tDoug\twoof!\n" +
                "dog\tHank\twoof!\n" +
                "dog\tLerf\twoof!\n" +
                "dog\tTucker\twoof!\n" +
                "snake\tFredley\tslither!\n" +
                "snake\tKark\tslither!\n" +
                "snake\tLamar\tslither!\n" +
                "spider\tAnnabelle\t(spider noises)!\n";
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testCompare2() {
        Integer numberOfPets = 9;
        String[] petTypes = {"snake", "cat", "dog", "cat", "cat", "snake", "snake", "snake", "cat"};
        String[] petNames = {"Hank", "Doug", "Lerf", "Tucker", "Charlie", "Lamar", "Fredley", "Kark", "Annabelle"};
        PetWarehouse house = new PetWarehouse(numberOfPets, petTypes, petNames);
        Pet[] pets = house.getPets();
        Arrays.sort(pets, new SortPets());
        String actual = house.toString();
        String expected =
                "cat\tAnnabelle\tmeow!\n" +
                "cat\tCharlie\tmeow!\n" +
                "cat\tDoug\tmeow!\n" +
                "cat\tTucker\tmeow!\n" +
                "dog\tLerf\twoof!\n" +
                "snake\tFredley\tslither!\n" +
                "snake\tHank\tslither!\n" +
                "snake\tKark\tslither!\n" +
                "snake\tLamar\tslither!\n";
        Assert.assertEquals(expected, actual);
    }
}
