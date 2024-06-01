import java.util.Arrays;
import java.util.HashMap;

public class Test2 {
    public static void main(String[] args) {
        int[] data = {2, 7, 4, 11};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(data, target)));
    }

    public static int[] twoSum(int[] array, int target) {
        HashMap<Integer, Integer> hs = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (hs.containsKey(target - array[i])) {
                return new int[]{i, hs.get(target - array[i])};
            }
            hs.put(array[i], i);
        }
        return new int[0];
    }
}
