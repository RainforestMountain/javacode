package test7;

import java.util.Arrays;

public class TreeArray {
    int[] elem = new int[101];
    int size = 0;

    public TreeArray(int[] data) {
        size = data.length;
        int[] sum = new int[data.length + 1];
        sum[0] = 0;
        for (int i = 1; i <= data.length; i++) {
            sum[i] = sum[i - 1] + data[i - 1];
        }
        for (int i = 1; i <= size; i++) {
            elem[i] = sum[i] - sum[i - lowBit(i)];
        }
    }

    public void printArray() {
        for (int i = 1; i <= size; i++) {
            System.out.print(elem[i] + " ");
        }
        System.out.println();
    }

    //修改原始数组data的index下标的值,elem会改很多值
    public void update(int index, int x, int post) {
        int i = index + 1;
        int addData = x - post;
        for (; i <= size; i += lowBit(i)) {
            elem[i] += addData;
        }
    }

    public int getSum(int index) {
        int i = index + 1;
        int ans = 0;
        while (i > 0) {
            ans += elem[i];
            i -= lowBit(i);
        }

        return ans;
    }

    public int lowBit(int n) {//一个数的二进制数,最后一个1到末尾的二进制序列,表示的十进制数,即以n结尾的树状数组区间的长度
        return n & -n;
    }

    public static void main(String[] args) {
        int[] arr = {8, 6, 1, 4, 5, 5, 1, 1, 3, 2, 1, 4, 9, 0, 7, 4};
        System.out.println(Arrays.toString(arr));
        TreeArray treeArray = new TreeArray(arr);
        treeArray.printArray();
        System.out.println(treeArray.getSum(15));
    }
}
