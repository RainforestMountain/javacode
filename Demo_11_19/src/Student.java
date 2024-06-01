public class Student implements Cloneable {
    private String name;

    private int age;

    public Salary salary;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.salary = new Salary(1000);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "name = " + this.name + " age = " + this.age + " salary = " + this.salary.salary;
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
}
