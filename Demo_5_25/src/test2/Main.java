package test2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        HashMap<List<Integer>, Integer> map = new HashMap<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(1);
        map.put(list1, 1);
        System.out.println(map.get(list2));

        HashMap<int[], Integer> map1 = new HashMap<>();
        map1.put(new int[]{1, 2}, 1);
        int[] arr = new int[]{1, 2};
        System.out.println(map1.get(arr));
    }
}
