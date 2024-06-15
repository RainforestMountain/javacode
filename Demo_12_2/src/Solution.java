import java.util.Stack;

public class Solution {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public void MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.empty()) {
            minStack.push(val);
        } else {
            int peekNum = minStack.peek();
            if (val <= peekNum) {
                minStack.push(val);
            }
        }
    }

    public void pop() {
        var data = stack.pop();
        var min = minStack.peek();
        if (data == min) {
            minStack.pop();
        }
    }

    //peek
    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static int reverse(int x) {
        long sum = 0;
        while (x != 0) {
            sum = sum * 10 + x % 10;
            x = x / 10;
        }
        if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) sum;
    }

    public static int myAtoi(String s) {
        int ret = 0;
        boolean flag = false;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ' && !Character.isDigit(s.charAt(i))
                    && s.charAt(i) != '+' && s.charAt(i) != '-') {
                break;
            }
            if (s.charAt(i) == '+' && !flag) {
                sign = 1;
                flag = true;
            }
            if (s.charAt(i) == '-' && !flag) {
                sign = -1;
                flag = true;
            }
            if (Character.isDigit(s.charAt(i))) {
                ret = ret * 10 + Integer.parseInt(s.charAt(i) + "");
            }
        }
        return ret * sign;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
        String s = "-25";
        System.out.println(Integer.parseInt(s));
        System.out.println(myAtoi("   -v8v9+"));
    }
}
