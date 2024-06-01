import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashSet;

public class TestDemo2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 4, 8, 8, 4, 6, 9, 9, 9, 9, 9, 9, 9, 9};
        System.out.println(numerousElement(arr));
    }

    public static int numerousElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
