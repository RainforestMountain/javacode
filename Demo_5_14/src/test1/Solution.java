package test1;

import java.util.*;

public class Solution {
//    public List<String> findRepeatedDnaSequences(String s) {
//        List<String> result = new LinkedList<>();
//        StringBuilder path = new StringBuilder();
//        if (s.length() <= 10) {
//            return result;
//        }
//
//        int left = 0;
//        int right = 0;
//
//
//        return null;
//    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int left = 0;
        int right = 0;
        int len = 0;
        TreeSet<Integer> set = new TreeSet<>();
        for (; right < nums.length; right++) {
            Integer y = set.ceiling(nums[right] - valueDiff);
            if (y != null && y <= nums[right] + valueDiff) {
                return true;
            }
            set.add(nums[right]);
            if (set.size() >= indexDiff + 1) {//窗口的长度其实是treeSet的长度,因为set会去重
                set.remove(nums[left]);
                left++;
            }
        }
        return false;
    }

//    public int[] smallestRange(List<List<Integer>> nums) {
//        List<Integer> path = new ArrayList<>();
//        TreeSet<Integer>[] sets = new TreeSet[nums.size()];
//        for (int i = 0; i < nums.size(); i++) {
//            sets[i] = new TreeSet<Integer>();
//            for (Integer val : nums.get(i)) {
//                path.add(val);
//                sets[i].add(val);
//            }
//        }
//        int left = 0;
//        int right = path.size() - 1;
//        int count = path.size();
//        while (count >= nums.size() && left < right) {
//
//        }
//
//
//        Collections.sort(path);
//
//
//    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int left = 0;
        int right = 0;
        List<Integer> result = new ArrayList<>();
        for (; right < nums.length; right++) {
            queue.add(nums[right]);
            if (right - left + 1 > k) {
                queue.remove(nums[left]);
                left++;
            }
            if (right - left + 1 == k) {
                result.add(queue.peek());
            }
        }
        if (result.isEmpty()) {
            return new int[0];
        }
        int[] ans = new int[result.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = result.get(i);
        }
        return ans;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] array = {1, 5, 9, 1, 5, 9};
//        System.out.println(solution.containsNearbyAlmostDuplicate(array, 2, 3));
//
//        TreeSet<Integer> set = new TreeSet<>();
//
//        set.add(1);
//        set.add(3);
//        set.add(2);
//        set.add(5);
//        set.add(4);
//        set.add(6);
//
//
//        System.out.println(set);
//        //set.ceiling(null);
//
//        System.out.println(set.subSet(2, true, 3, true));
//
//        System.out.println(set.descendingSet());
//
//        int[] array2 = new int[]{1, 2, 3, 4, 5, 6};
//        array2 = Arrays.stream(array2).boxed().sorted(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        }).mapToInt(Integer::intValue).toArray();
//        System.out.println(Arrays.toString(array2));

        solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }
}
