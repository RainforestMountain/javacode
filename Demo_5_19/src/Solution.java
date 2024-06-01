import java.util.*;

public class Solution {

    public int trap1(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        //单调栈,
        Stack<Integer> stack = new Stack<>();
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < height.length; i++) {
            if (height[i] != 0) {
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
                        int left = stack.pop();
                        int right = i;
                        if (right - left + 1 > 2) {
                            result.add(new int[]{left, right});
                        }
                    }
                    stack.push(i);
                }

            }
        }
        stack.clear();
        for (int i = height.length - 1; i >= 0; i--) {
            if (height[i] != 0) {
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
                        int right = stack.pop();
                        int left = i;
                        if (right - left + 1 > 2) {
                            result.add(new int[]{left, right});
                        }
                    }
                    stack.push(i);
                }

            }
        }
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
        //计算雨水体积

        Collections.sort(result, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]) {
                    return 1;
                } else if (o1[0] < o2[0]) {
                    return -1;
                } else {
                    return o2[1] - o1[1];
                }
            }
        });
        int ret = 0;
        for (int i = 0; i < result.size(); i++) {
            int[] path = result.get(i);
            if (i == 0) {
                int h = Math.min(height[path[0]], height[path[1]]);
                for (int j = path[0] + 1; j < path[1]; j++) {
                    ret += h - height[j];
                }
            } else {
                if (path[0] < result.get(i - 1)[1]) {
                    result.get(i)[1] = Math.max(path[1], result.get(i - 1)[1]);
                    continue;
                } else {
                    int h = Math.min(height[path[0]], height[path[1]]);
                    for (int j = path[0] + 1; j < path[1]; j++) {
                        ret += h - height[j];
                    }
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] array = {4, 2, 3};
        System.out.println(new Solution().trap1(array));
    }
}
