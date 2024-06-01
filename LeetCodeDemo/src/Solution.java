import java.util.HashMap;

public class Solution {
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        //双指针
        int area = 0;
        int value = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                value = Math.min(height[left], height[right]) * (right - left);
                left++;
            } else {
                value = Math.min(height[left], height[right]) * (right - left);
                right--;
            }
            if (value > area) {
                area = value;
            }
        }
        return area;
    }

//    public static void main(String[] args) {
//        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
//        System.out.println(maxArea(arr));
//    }

    public static String intToRoman(int num) {
        HashMap<Integer, String> map1 = new HashMap<>();
        map1.put(1, "I");
        map1.put(5, "V");
        map1.put(10, "X");
        map1.put(50, "L");
        map1.put(100, "C");
        map1.put(500, "D");
        map1.put(1000, "M");
        int[] nums = {1, 10, 100, 1000};
        int i = nums.length - 1;
        HashMap<Integer, String> map2 = new HashMap<>();
        map2.put(4, "IV");
        map2.put(9, "IX");
        map2.put(40, "XL");
        map2.put(90, "XC");
        map2.put(400, "CD");
        map2.put(900, "CM");
        StringBuilder str = new StringBuilder();

        while (num > 0) {
            int temp = 0;
            if ((temp = num / nums[i]) > 0 && temp < 10) {
                switch (temp) {
                    case 5, 6, 7, 8 -> {
                        str.append(map1.get(5 * nums[i]));
                        num = num - 5 * nums[i];
                    }
                    case 4, 9 -> {
                        str.append(map2.get(temp * nums[i]));
                        num = num - temp * nums[i];
                    }
                    default -> {
                        for (int j = 0; j < temp; j++) {
                            str.append(map1.get(nums[i]));
                        }
                        num = num - temp * nums[i];
                    }
                }
            } else {
                i--;
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String s = intToRoman(2596);
        System.out.println(s);
    }
}
