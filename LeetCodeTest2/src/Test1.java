import java.util.Stack;

public class Test1 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (!isOperation(tokens[i])) {
                st.push(Integer.valueOf(tokens[i]));
            } else {
                if (!st.isEmpty()) {
                    int n2 = st.pop();
                    int n1 = st.pop();
                    String s = tokens[i];
                    int ans = 0;
                    switch (s) {
                        case "+" -> ans = n1 + n2;
                        case "-" -> ans = n1 - n2;
                        case "*" -> ans = n1 * n2;
                        case "/" -> ans = n1 / n2;
                    }
                    st.push(ans);
                }
            }
        }
        return st.pop();
    }

    public boolean isOperation(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char data = s.charAt(i);
            if (data == '(' || data == '[' || data == '{') {
                stack.push(data);
            } else {
                if (stack.isEmpty()) {
                    char e = stack.pop();
                    switch (data) {
                        case ')' -> {
                            if (e != '(') {
                                return false;
                            }
                        }
                        case ']' -> {
                            if (e != '[') {
                                return false;
                            }
                        }
                        case '}' -> {
                            if (e != '{') {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean IsPopOrder(int[] pushV, int[] popV) {
        // write code here

        Stack<Integer> st = new Stack<>();
        for (int i = 0, j = 0; i < pushV.length && j < popV.length; i++) {
            if (st.isEmpty() || st.peek() != popV[j]) {
                st.push(pushV[i]);
            }
            if (!st.isEmpty() && st.peek() == popV[j]) {
                while (!st.isEmpty() && st.peek() == popV[j] && j < popV.length) {
                    st.pop();
                    j++;
                }
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        IsPopOrder(new int[]{1}, new int[]{1});
    }
}
