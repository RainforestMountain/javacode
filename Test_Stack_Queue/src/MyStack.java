import java.util.Arrays;
import java.util.Stack;

public class MyStack {
    int[] array;
    int size;

    public MyStack() {
        array = new int[5];//初始化栈,初始容量为5
    }

    //入栈,从栈顶入栈
    public int push(int e) {
        ensureCapacity();//确保栈有足够的容量,如果不够就会扩容
        array[size++] = e;
        return e;
    }

    //元素出栈,也从栈顶出栈,并不是将元素直接删除,而是将size减小,让栈不包含这个元素,以后再次入栈直接覆盖即可
    public int pop() {
        int e = peek();
        size--;
        return e;
    }

    //获取栈顶元素,如果为空,会抛出异常
    public int peek() {
        if (empty()) {
            throw new RuntimeException("栈为空，无法获取栈顶元素");
        }
        return array[size - 1];
    }

    //获取大小
    public int size() {
        return size;
    }

    //判断栈是否为空
    public boolean empty() {
        return 0 == size;
    }

    //检查容量,不够就会扩容,将原数组进行拷贝
    private void ensureCapacity() {
        if (size == array.length) {
            array = Arrays.copyOf(array, size * 2);
        }
    }

    //用递归函数实现阶乘
    public static int factorial1(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial1(n - 1);
    }

    //用栈实现递归阶乘
    public static int factorial2(int n) {
        if (n == 1) {
            return 1;
        }
        Stack<Integer> stack = new Stack<>();
        //将1到n进栈,类似递归
        for (int i = n; i > 0; i--) {
            stack.push(i);
        }
        int ret = 1;
        //依次出栈类似回溯,然后用ret记录每次回溯的结果,最后元素出栈ret就是结果了
        while (!stack.empty()) {
            ret = ret * stack.pop();
        }
        return ret;
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println(s.size()); // 获取栈中有效元素个数---> 4
        System.out.println(s.peek()); // 获取栈顶元素---> 4
        s.pop(); // 4出栈，栈中剩余1 2 3，栈顶元素为3
        System.out.println(s.pop()); // 3出栈，栈中剩余1 2 栈顶元素为3
        if(s.empty()){
            System.out.println("栈空");
        }else{
            System.out.println(s.size());
        }
    }


}