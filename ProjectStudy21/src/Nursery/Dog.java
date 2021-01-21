package Nursery;

public class Dog {

    private String name;
    private int age;
    private boolean sex;
    private int speed;

    public Dog(String name, int age, boolean sex, int speed) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", speed=" + speed +
                '}';
    }
}
