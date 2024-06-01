import java.util.*;
public class CoreObject {
    protected String name;
    protected int age;
    public double salary;

    public CoreObject(String name, int age,double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    //toString
    @Override
    public String toString() {
       return ("name: " + name+" age: " + age+" salary: " + salary);
    }

    //equals
    @Override
    public boolean equals(Object obj1){
        if(obj1 instanceof CoreObject){
            return this.name.equals(((CoreObject)obj1).name)&&
                    this.salary==(((CoreObject)obj1).salary)&&
                    this.age==(((CoreObject)obj1).age);
        }
        else
            return false;
    }
    //hashCode
    @Override
    public int hashCode() {
        return Objects.hash(name,age,salary);
    }
    public static void main(String[] args) {
        var person1=new CoreObject("jerry",21,8900);
        var person2=new CoreObject("jerry",28,8900);
        System.out.println(person1.toString());
        System.out.println(person1.equals(person2));
        System.out.printf("%X\n",person1.hashCode());
    }
}