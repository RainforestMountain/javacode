package newcom.getfiled;

import newcom.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public class TestDemo3 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class c = Class.forName("newcom.Student");

        Field[] fields1 = c.getDeclaredFields();
        for (Field field : fields1) {
            System.out.println(field);
        }
        //返回本类和父类公共的成员变量
        Field[] fields2 = c.getFields();
        for (Field field : fields2) {
            System.out.println(field);
        }
        System.out.println("----------------------");
        Field field1 = c.getDeclaredField("name");
        field1.setAccessible(true);
        System.out.println(field1);
        int modifiers1 = field1.getModifiers();
        System.out.println(Modifier.toString(modifiers1));
        String name = field1.getName();
        System.out.println(name);
        Constructor con = c.getDeclaredConstructor(String.class, String.class, int.class);
        con.setAccessible(true);
        Student s = (Student) con.newInstance("lisi", "nanjing", 19);
        Object o = field1.get(s);
        System.out.println(o);
        field1.set(s, "zhangsan");
        o = field1.get(s);
        System.out.println(o);
    }
}
