import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        int pk = 0;
        List<List<Integer>> result = new ArrayList<>();
        while (pk < nums.length - 2) {
            int left = pk + 1;
            int right = nums.length - 1;
            if (nums[pk] > 0) {
                break;
            } else {
                while (left < right) {
                    if (nums[left] + nums[right] > -nums[pk]) {
                        right--;
                    } else if (nums[left] + nums[right] < -nums[pk]) {
                        left++;
                    } else {
                        List<Integer> path = new ArrayList<>();
                        Collections.addAll(path, nums[pk], nums[left], nums[right]);
                        result.add(path);
                        //对left 和 right去重
                        int postLeft = nums[left];
                        while (left < right && nums[left + 1] == postLeft) {
                            left++;
                        }
                        int postRight = nums[right];
                        while (left < right && nums[right - 1] == postRight) {
                            right--;
                        }
                        left++;
                        right--;
                    }
                }
            }
            //System.out.println(pk);
            //对 K 去重
            int postK = nums[pk];
            while (pk < nums.length - 2 && postK == nums[pk + 1]) {
                pk++;
            }
            pk++;
        }
        return result;
    }

    public static void main1(String[] args) {
        Solution solution = new Solution();
        solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }

    public int[] twoSum(int[] price, int target) {
        price = Arrays.stream(price).boxed().sorted().mapToInt(value -> value).toArray();
        //Arrays.sort(price);
        int[] ans = new int[2];
        int left = 0;
        int right = price.length - 1;
        while (left < right) {
            if (price[left] + price[right] > target) {
                right--;
            } else if (price[left] + price[right] < target) {
                left++;
            } else {
                ans[0] = price[left];
                ans[1] = price[right];
                return ans;
            }
        }

        //List<Integer> list = new ArrayList<>(Arrays.a)
        return new int[0];
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; ) {
            for (int j = i + 1; j < nums.length - 2; ) {
                int a = nums[i];
                int b = nums[j];
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = a + b + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        List<Integer> path = new ArrayList(Arrays.asList(a, b, nums[left], nums[right]));
                        result.add(path);
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    }
                }
                j++;
                while (j < nums.length - 2 && nums[j] == nums[j - 1]) {
                    j++;
                }
            }
            i++;
            while (i < nums.length - 3 && nums[i] == nums[i - 1]) {
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.fourSum(new int[]{1, -2, -5, -4, -3, 3, 3, 5}, -11);
    }
}