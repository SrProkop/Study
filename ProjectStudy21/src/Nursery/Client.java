package Nursery;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Client {
    public static void main(String[] args) {
        ArrayList<Dog> dogs = new ArrayList<>();

        dogs.add(new Dog("Dog1", 5, true, 10));
        dogs.add(new Dog("Dog2", 4, true, 12));
        dogs.add(new Dog("Dog3", 6, false, 8));
        dogs.add(new Dog("Dog4", 3, true, 15));
        dogs.add(new Dog("Dog5", 7, false, 9));
        dogs.add(new Dog("Dog6", 2, true, 7));
        dogs.add(new Dog("Dog7", 8, false, 5));

        allNursery(dogs);
        System.out.println("");
        fastDog(dogs);
        System.out.println("");
        slowDog(dogs);
        System.out.println("");
        System.out.println("Средняя скорость в питомнике: " + middleSpeed(dogs));
        System.out.println("");
        youngDog(dogs);
        System.out.println("");
        allGirl(dogs);
        System.out.println("");
        allSlowBoy(dogs);
        System.out.println("");

    }

    public static void allNursery(ArrayList<Dog> dogs) {
        dogs.stream().forEach(dog -> System.out.println(dog.toString()));
    }

    public static void fastDog(ArrayList<Dog> dogs) {
        int speed = dogs.get(0).getSpeed();
        Dog fastDog = dogs.get(0);

        for (Dog dog : dogs) {
            if (dog.getSpeed() > speed) {
                fastDog = dog;
            }
        }
        System.out.println(fastDog.toString());
    }

    public static void slowDog(ArrayList<Dog> dogs) {
        int speed = dogs.get(0).getSpeed();
        Dog slowDog = dogs.get(0);

        for (Dog dog : dogs) {
            if (dog.getSpeed() < speed) {
                slowDog = dog;
            }
        }
        System.out.println(slowDog.toString());
    }

    public static int middleSpeed(ArrayList<Dog> dogs) {
        int count = 0;
        int speed = 0;

        for (Dog dog : dogs) {
            speed += dog.getSpeed();
            count++;
        }
        return (speed/count);
    }

    public static void youngDog(ArrayList<Dog> dogs) {
        int age = dogs.get(0).getAge();
        Dog youngDog = dogs.get(0);

        for (Dog dog : dogs) {
            if (dog.getAge() < age) {
                youngDog = dog;
            }
        }
        System.out.println(youngDog.toString());
    }

    public static void allGirl(ArrayList<Dog> dogs) {
        List<Dog> dogList;
        dogList = dogs.stream().filter(dog -> !dog.isSex()).collect(Collectors.toList());
        dogList.sort(Comparator.comparing(Dog::getAge));
        dogList.forEach(dog -> System.out.println(dog.toString()));
    }

    public static void allSlowBoy(ArrayList<Dog> dogs) {
        List<Dog> dogList;
        dogList = dogs.stream().filter(dog -> dog.isSex()).collect(Collectors.toList());
        dogList.stream().filter(dog -> dog.getSpeed() < middleSpeed(dogs));
        dogList.forEach(dog -> System.out.println(dog.toString()));
    }
}
