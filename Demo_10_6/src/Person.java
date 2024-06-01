public class Person {
    String name;
    int age;
    String address;

    public static void main(String[] args) {
        var person = new Person();
        System.out.println(person.toString());
        System.out.println(person.hashCode());
    }

    public record person(String name, int age, String address) {
    }
}