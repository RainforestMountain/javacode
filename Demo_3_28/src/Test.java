public class Test {

    public static int binarySearch1(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == key) {
                return mid;
            } else if (array[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static int binarySearch2(int[] array, int key, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) /2;
        if (array[mid] == key) {
            return mid;
        } else if (array[mid] < key) {
            return binarySearch2(array, key, mid + 1, right);
        } else {
            return binarySearch2(array, key, left, mid - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 9};
        System.out.println(binarySearch1(arr, 0));
        System.out.println(binarySearch2(arr, -1, 0, arr.length - 1));
    }
}

