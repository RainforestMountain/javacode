public class CloneTest {


    public static void main(String[] args) throws CloneNotSupportedException {
        Student s1 = new Student("ZhangSan", 15);
        Student s2 = (Student) s1.clone();
        m
        System.out.println("s1" + s1);
        System.out.println("s2" + s2);

        s1.salary.salary = 10;
        System.out.println("s1" + s1);
        System.out.println("s2" + s2);
    }
}
