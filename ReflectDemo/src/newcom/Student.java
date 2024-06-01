package newcom;

import java.lang.reflect.InvocationTargetException;

public class Student extends People {
    private String name;
    private String adress;
    private int age;

    private Student(String name, String adress, int age) {
        this.name = name;
        this.adress = adress;
        this.age = age;
    }

    public Student() {
    }

    private void study(String book) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        System.out.println(name + " is studying " + book);
    }

    protected int compute(int n) {
        return n / 2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", age=" + age +
                '}';
    }
}
