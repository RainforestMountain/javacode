package org.Test;

import java.util.*;

public class TestDemo2 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(20, -5, 49, 8);
        Collections.sort(numbers);
        for (Integer n : numbers) {
            System.out.print(n + " ");
        }
        System.out.println("\n");

        List<String> names = Arrays.asList("this", "is", "a", "string");
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        for (String name : names) {
            System.out.print(name + " ");
        }
        System.out.println("\n");

        List<Integer> list = Arrays.asList(5, 3, 1, 7);
        Integer key = 4;
        int pos = Collections.binarySearch(list, key, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println(pos);
        //将键插入到正确的位置
        if (pos < 0) {
            List<Integer> nlist = new ArrayList<>(list);
            nlist.add(-pos - 1, key);
            System.out.println(nlist);
        }
        System.out.println();

        Integer[] num = new Integer[]{1, 3, 5, 6, 4, 7, 9, 10};
        List<Integer> list1 = Arrays.asList(num);
        System.out.println(Arrays.toString(num));
        Collections.sort(list1);
        System.out.println(list1);
        Collections.shuffle(list1, new Random());
        System.out.println(list1);

        int max = Collections.max(list1);
        System.out.println(max);
        int min = Collections.min(list1);
        System.out.println(min);
        Collections.reverse(list1);
        System.out.println(list1);
        Collections.fill(list1, 5);
        System.out.println(list1);
        Collections.copy(list1, list);
        System.out.println(list1);
        Collections.swap(list1, 2, 3);
        System.out.println(list1);
        System.out.println(Collections.frequency(list1, 2));
        System.out.println(Collections.disjoint(list1, list));
        Collections.rotate(list1, 2);
        System.out.println(list1);

    }
}
