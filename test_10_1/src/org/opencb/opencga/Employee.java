package org.opencb.opencga;

public class Employee extends Person {
    public double salary;

    public Employee() {

    }

    public Employee(double salary) {
        this.salary = salary;
    }

    public Employee(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    public static void main(String[] args) {
        Employee employee = new Employee("artin", 25, 3000);
        System.out.println("my age is " + employee.age);
        System.out.println("my name is " + employee.name);
        employee.sayHello();
        System.out.println(employee.computeSalary(72 * 4, 40));
    }

    public double computeSalary(int hours, double rate) {
        return this.salary + hours * rate;
    }
}