package nursery;

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
        dogs.sort(Comparator.comparing(Dog::getSpeed));
        System.out.println(dogs.get(dogs.size() - 1));
    }

    public static void slowDog(ArrayList<Dog> dogs) {
        dogs.sort(Comparator.comparing(Dog::getSpeed));
        System.out.println(dogs.get(0));
    }

    public static int middleSpeed(ArrayList<Dog> dogs) {
        int speed = 0;

        for (Dog dog : dogs) {
            speed += dog.getSpeed();
        }

        return (speed/(dogs.size() - 1));
    }

    public static void youngDog(ArrayList<Dog> dogs) {
        dogs.sort(Comparator.comparing(Dog::getAge));
        System.out.println(dogs.get(0));
    }

    public static void allGirl(ArrayList<Dog> dogs) {
        dogs.stream()
                .filter(dog -> !dog.isSex())
                .sorted(Comparator.comparing(Dog::getAge))
                .forEach(dog -> System.out.println(dog.toString()));
    }

    public static void allSlowBoy(ArrayList<Dog> dogs) {
        dogs.stream()
                .filter(dog -> dog.isSex())
                .sorted(Comparator.comparing(Dog::getAge))
                .forEach(dog -> System.out.println(dog.toString()));
    }
}
