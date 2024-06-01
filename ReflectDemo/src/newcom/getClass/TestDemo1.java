package newcom.getClass;

import newcom.Student;

public class TestDemo1 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class c1 = Class.forName("newcom.Student");
//        Class c2 = Student.class;
//        var s = new Student();
//        Class c3 = s.getClass();
//        System.out.println(c1);
//        System.out.println(c1 == c2);
//        System.out.println(c2 == c3);

        Student student = (Student) c1.newInstance();

        student.setAge(20);
        student.setName("lisi");
        student.setAdress("paris");
        System.out.println(student);

    }
}
