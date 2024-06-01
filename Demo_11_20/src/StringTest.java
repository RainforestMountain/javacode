import javax.print.DocFlavor;
import java.util.Vector;

public class StringTest {

    public static void main(String[] args) {
        String str1 = "hello" + " world";
        String str2 = "hello world";

        System.out.println(str1 == str2);

        Vector<Integer> vector = new Vector<>();

        vector.add(5);
        vector.add(4);
        System.out.println(vector);

        Vector<String> vector1 = new Vector<>();

        vector1.add("hello");
        vector1.add("world");

        System.out.println(vector1);
    }
}
