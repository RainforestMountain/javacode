package test2;

public class MidNum {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 8, 9, 12};
        int[] nums2 = {2, 4, 5, 10, 13};
        int n = nums1.length;
        int m = nums2.length;
        int[] merged = new int[n + m];
        int i = 0, j = 0, count = 0;

        while (count <= (m + n) / 2) {
            int num1 = i < n ? nums1[i] : Integer.MAX_VALUE;
            int num2 = j < m ? nums2[j] : Integer.MAX_VALUE;

            if (num1 <= num2) {
                merged[count++] = num1;
                i++;
            } else {
                merged[count++] = num2;
                j++;
            }
        }

        double ret = (n + m) % 2 == 0 ? (double) (merged[(n + m) / 2 - 1] + merged[(n + m) / 2]) / 2 : merged[(n + m) / 2];
        System.out.println(ret);
    }
}
