package newcom.getmethod;

import newcom.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class TestDemo4 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class c = Class.forName("newcom.Student");

        Method[] methods1 = c.getMethods();
        for (Method method : methods1) {
            System.out.println(method);
        }
        System.out.println("--------------------");

        Method[] methods2 = c.getDeclaredMethods();
        for (Method method : methods2) {
            System.out.println(method);
        }

        Method method1 = c.getDeclaredMethod("study", String.class);
        int modifiers1 = method1.getModifiers();
        System.out.println(modifiers1);
        System.out.println(Modifier.toString(modifiers1));
//        Class<? extends Method> method1Class = method1.getClass();
//        System.out.println(method1Class);

        int parameterCount1 = method1.getParameterCount();
        System.out.println(parameterCount1);
        Class[] parameterTypes1 = method1.getParameterTypes();
        for (Class parameterType : parameterTypes1) {
            System.out.println(parameterType);
        }
        Class returnType1 = method1.getReturnType();
        System.out.println(returnType1);
        Class[] method1ExceptionTypes = method1.getExceptionTypes();
        for (Class exceptionType : method1ExceptionTypes) {
            System.out.println(exceptionType);
        }

        Constructor con = c.getDeclaredConstructor(String.class, String.class, int.class);
        con.setAccessible(true);
        Student s = (Student) con.newInstance("lisi", "nanjing", 19);
        method1.setAccessible(true);
        method1.invoke(s, "三国演义");

        Method method2 = c.getDeclaredMethod("compute", int.class);
        method2.setAccessible(true);
        Object o = method2.invoke(s, 2000);
        System.out.println(o);

    }
}
