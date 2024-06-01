package newcom.getconstructer;

import newcom.Student;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public class TestDemo2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class c = Class.forName("newcom.Student");

        Constructor[] cons = c.getDeclaredConstructors();
        for (Constructor con : cons) {
            System.out.println(con);
        }
        System.out.println("-------------------------");
        Constructor con = c.getDeclaredConstructor(String.class, String.class, int.class);
        con.setAccessible(true);
        System.out.println(con);
        Student s = (Student) con.newInstance("lisi", "nanjing", 26);
        System.out.println(s);
        System.out.println("------------------------------");
        int modifiers = con.getModifiers();
        System.out.println(Modifier.toString(modifiers));
        String name = con.getName();
        System.out.println(name);
        //返回注解
        Annotation[][] parameterAnnotations = con.getParameterAnnotations();
        for (int i = 0; i < parameterAnnotations.length; i++) {
            for (int j = 0; j < parameterAnnotations[i].length; j++) {
                System.out.println(parameterAnnotations[i][j]);
            }
        }
        Class[] parameterTypes = con.getParameterTypes();
        for (Class parameterType : parameterTypes) {
            System.out.println(parameterType);
        }
        System.out.println(con.getParameterCount());
    }
}
