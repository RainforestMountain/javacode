public class Test {
    //楼梯一次最多爬三节
    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }
        return climbStairs(n - 1) + climbStairs(n - 2) + climbStairs(n - 3);
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }
}
