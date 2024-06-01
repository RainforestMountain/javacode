package test1;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //数组元素互不相等
    public int OrderStatistic(int nums[], int k) {
        //划分
        //就选 下标为k的元素来划分
        int base = nums[k - 1];
        List<Integer> s1 = new ArrayList<>();
        List<Integer> s2 = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < base) {
                s1.add(nums[i]);
            } else if (nums[i] > base) {
                s2.add(nums[i]);
            }
        }
        if (s1.size() == k - 1) {
            return base;
        } else if (s1.size() > k - 1) {
            int[] arr = new int[s1.size()];
            for (int i = 0; i < s1.size(); i++) {
                arr[i] = s1.get(i);
            }
            //在s1中继续查找
            return OrderStatistic(arr, k);
        } else {
            //在s2中查找,排除了s1,s2,那么k要减去(s1.size() + 1)
            int[] arr = new int[s2.size()];
            for (int i = 0; i < s2.size(); i++) {
                arr[i] = s2.get(i);
            }

            return OrderStatistic(arr, k - (s1.size() + 1));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.OrderStatistic(new int[]{1, 5, 8, 4, 6, 3}, 2));
    }


}
