package test4;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int kl = (nums1.length + nums2.length + 1) / 2;
        int kr = (nums1.length + nums2.length + 2) / 2;
        return (getMid(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, kl)
                + getMid(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, kr)) / 2.0;

    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int kl = (n + m + 1) / 2;
        int kr = (n + m + 2) / 2;
        int ret1 = 0;
        int ret2 = 0;
        // 求两次
        int l1 = 0;
        int r1 = n - 1;
        int l2 = 0;
        int r2 = m - 1;
        while (true) {
            if (l1 > r1) {
                ret1 = nums2[l2 + kl - 1];
                break;
            }
            if (l2 > r2) {
                ret1 = nums1[l1 + kl - 1];
                break;
            }
            int i = l1;
            int j = l2;
            if (kl == 1) {
                ret1 = Math.min(nums1[i], nums2[j]);
                break;
            }
            i = l1 + Math.min(r1 - l1 + 1, kl / 2) - 1;
            j = l2 + Math.min(r2 - l2 + 1, kl / 2) - 1;

            if (nums1[i] > nums2[j]) {
                kl = kl - (j - l2 + 1);
                l2 = j + 1;
            } else {
                kl = kl - (i - l1 + 1);
                l1 = i + 1;
            }
        }
        l1 = 0;
        r1 = n - 1;
        l2 = 0;
        r2 = m - 1;
        while (true) {
            if (l1 > r1) {
                ret2 = nums2[l2 + kr - 1];
                break;
            }
            if (l2 > r2) {
                ret2 = nums1[l1 + kr - 1];
                break;
            }
            int i = l1;
            int j = l2;
            if (kr == 1) {
                ret2 = Math.min(nums1[i], nums2[j]);
                break;
            }
            i = l1 + Math.min(r1 - l1 + 1, kr / 2) - 1;
            j = l2 + Math.min(r2 - l2 + 1, kr / 2) - 1;
            if (nums1[i] > nums2[j]) {
                kr = kr - (j - l2 + 1);
                l2 = j + 1;
            } else {
                kr = kr - (i - l1 + 1);
                l1 = i + 1;
            }

        }
        return (ret1 + ret2) / 2.0;
    }

    public double getMid(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        //二分
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        if (len1 <= 0) {
            return nums2[start2 + k - 1];
        }
        if (len2 <= 0) {
            return nums1[start1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int i = start1 + Math.min(len1, k / 2) - 1;//取长度和k / 2的最小值防止越界
        int j = start2 + Math.min(len2, k / 2) - 1;
        if (nums1[i] > nums2[j]) {
            //接下来递归函数的k应该是减去排除了哪些元素,k是奇数时,k / 2并不准确
            return getMid(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        } else {
            return getMid(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays2(
                new int[]{1}, new int[]{2,3,4,5,6}));
    }
}
