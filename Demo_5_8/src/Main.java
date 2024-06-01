import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Integer[] data = {1, 2, 3, 4, 5, 6};
//        Collections.addAll(list, data);必须是引用类型数组,基本类型数组不会整体装箱
        Collections.addAll(list, 1,2,3,4);
//        Stream<Integer> stream = list.stream();
////        Iterator<Integer> iterator = stream.iterator();
////        while (iterator.hasNext()) {
////            System.out.println(iterator.next());
////        }
//        System.out.println("==================");
//        //stream流只能用一次
//        stream.forEach(s -> System.out.println(s));

//        list.stream().forEach(s -> System.out.println(s));
//        System.out.println("=============");
//        list.stream().limit(3).skip(1).forEach(s -> System.out.println(s));
//
//        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
//        array = Arrays.stream(array).boxed().sorted(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        }).mapToInt(value -> value.intValue()).toArray();

        double[] arr = {1, 2, 1, 3.5, 5.9, 2.6, -8.5};
        arr = Arrays.stream(arr).boxed().sorted((o1, o2) -> {//排序中compare返回值大于0才交换,且交换前的顺序是o1在o2前面
            return (int) (Math.abs(o2) - Math.abs(o1));
        }).mapToDouble(value -> value).toArray();
        System.out.println(Arrays.toString(arr));



        // Arrays.sort();
    }
}
