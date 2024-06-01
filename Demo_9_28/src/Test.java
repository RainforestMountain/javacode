class Animal {
    public static final int average_age = 5;
    public int age;

    public Animal(int a) {
        this.age = a;
    }

    public Animal() {
        age = 1;
    }
}

public class Test {
    public static void increment(int values, Animal animal) {
        //值传递
        values++;
        //引用传递
        animal.age++;
    }

    public static void main(String[] args) {
        Animal myDog = new Animal();
        int values = 10;
        for (var i = 0; i < values; i++) {
            increment(values, myDog);
        }
        System.out.println(values);
        System.out.println(myDog.age);
    }
}