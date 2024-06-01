import java.util.ArrayList;
import java.util.List;

public class BoundedTypeDemo {
    public static double getAverage(List<? extends Number> numberList) {
        var total = 0.0;
        for (var number : numberList) {
            total += number.doubleValue();
        }
        return total / numberList.size();
    }

    public static void main(String[] args) {
        var integerList = new ArrayList<Integer>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        System.out.println(getAverage(integerList));
        integerList.add(4);
        integerList.add(5);
        
    }
}
