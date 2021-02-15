package circus;

import circus.animal.Animal;
import circus.animal.Duck;
import circus.animal.Parrot;
import circus.stuff.Cage;
import circus.stuff.Cannon;
import circus.stuff.Equipment;
import circus.stuff.Ladder;

import java.util.ArrayList;
import java.util.Arrays;

public class Circus {
    private static Animal[] animals = {
            new Duck("Drake"),
            new Parrot("Polly")
    };
    private static Equipment[] equipments = {
            new Ladder(50),
            new Cannon(5),
            new Cannon(100)
    };

    private static void makeAnimalsTalk() {
        for (Animal a : animals) {
            System.out.println(a);
            System.out.println(a.speak());
        }
    }

    private static int calculateAssetValue(Asset[] assets) {
        int total = 0;
        for (Asset a : assets) {
            if (a.getValue() <= 5) {
                System.out.println("Ignoring low value item: " + a.getValue());
                continue;
            }

            total += a.getValue();
            System.out.println("Adding item value: " + a.getValue());
        }
        return total;
    }

    public static void main(String[] args) {

        ArrayList<Animal> animalArrayList = new ArrayList<>(Arrays.asList(animals));
        printAllAnimals(animalArrayList);

        Duck louie = new Duck("Louie");
        animalArrayList.add(louie);
        Duck huey = new Duck("Huey");
        animalArrayList.add(huey);
        Duck dewey = new Duck("Dewie");
        animalArrayList.add(dewey);
        printAllAnimals(animalArrayList);
        System.out.println("Index of Louie before sorting: " + animalArrayList.indexOf(louie));

        animalArrayList.sort(Animal.AnimalNameComparator);
        printAllAnimals(animalArrayList);
        System.out.println("Index of Louie after sorting: " + animalArrayList.indexOf(louie));

        makeAnimalsTalk();
        System.out.println("Total value of animals " + calculateAssetValue(animals));
        System.out.println("Total value of equipments " + calculateAssetValue(equipments));
        Cage<Duck> duckCage = new Cage<>();
        Duck duck = new Duck("Donald");
        duckCage.lockUp(duck);
        Parrot parrot = new Parrot("Polly #2");
        Cage<Parrot> parrotCage = new Cage<>();
        parrotCage.lockUp(parrot);

        ArrayList<Cage> cages = new ArrayList<>();
        cages.add(duckCage);
        cages.add(parrotCage);

        for (Cage c : cages) {
            c.release();
        }
    }

    private static void printAllAnimals(ArrayList<Animal> animalArrayList) {
        for (Animal animal : animalArrayList) {
            System.out.println(animal);
        }
    }

}