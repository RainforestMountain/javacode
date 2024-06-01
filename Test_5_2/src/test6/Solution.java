package test6;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //先对行查找
        int left = 0;
        int right = matrix.length - 1;

        while (left < right) {
            int mid = left + ((right - left + 1) >> 1);
            if (matrix[mid][0] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        int row = left;
        //在这一行进行二分查找
        left = 0;
        right = matrix[row].length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (matrix[row][mid] == target) {
                return false;
            } else if (matrix[row][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
