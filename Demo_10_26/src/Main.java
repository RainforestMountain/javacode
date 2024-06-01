//import java.util.Scanner;
//
//interface Comparator {
//    /**
//     * 返回两个整数中的最大值
//     */
//    int max(int x, int y);
//}
//
//public class Main {
//
//    public static void main(String[] args) {
//        Comparator comparator = new ComparatorImpl();
//
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNextInt()) {
//            int x = scanner.nextInt();
//            int y = scanner.nextInt();
//            System.out.println(comparator.max(x, y));
//        }
//    }
//
//}
//
////write your code here......
//class ComparatorImpl implements Comparator {
//    public int max(int x, int y) {
//        return Math.max(x, y);
//    }
//}

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String className = scanner.next();
            // print就是需要你定义的方法
            print(Class.forName(className).newInstance());
        }
    }

    //write your code here......
    public static void print(Object obj) {
        //obj指向由其引用数据类型(Object类)的子类对象向上转换而成的对象,然后编译器根据对象的实际类型调用子类方法
        System.out.println(obj.toString());
    }

}

class First {
    public String toString() {
        return "First";
    }
}

class Second {
    public String toString() {
        return "Second";
    }
}

class Third {
    public String toString() {
        return "Third";
    }
}
