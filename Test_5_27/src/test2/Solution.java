package test2;

public class Solution {
    public int missingNumber(int[] nums) {
        //异或运算, 0 ~ N 和数组一起异或结果就是剩下的元素
        int ret = 0;
        for (int val : nums) {
            ret = ret ^ val;
        }
        int n = nums.length;
        for (int i = 0; i <= n; i++) {
            ret = ret ^ i;
        }
        return ret;
    }

    public int getSum(int a, int b) {
        //无进位相加,再加上进位,需要循环
        int ret = a ^ b;
        int carry = (a & b) << 1;//进位
        while (carry != 0) {
            int tmp = ret;//防止ret因无进位相加而丢失原始数据
            ret = ret ^ carry;//无进位相加
            carry = (tmp & carry) << 1;//进位,但是要左移一位,表示向前进位
        }
        return ret;
    }

    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            //获取第i位比特位
            int sum = 0;
            for (int num : nums) {
                sum += (num >> i) & 1;
            }
            //修改ret第i位
            if (sum % 3 == 0) {
                ret = ret & (~(1 << i));
            } else {
                ret = ret | (1 << i);
            }
        }
        return ret;
    }
}
