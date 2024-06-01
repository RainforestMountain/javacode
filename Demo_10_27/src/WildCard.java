import java.util.ArrayList;
import java.util.List;

public class WildCard {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        printList(list1);

    }

    public static void printList(List<?> list) {
        for (Object element : list) {
            System.out.println(element);
        }
    }
}


