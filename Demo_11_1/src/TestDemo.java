public class TestDemo {
    public static void hanoi(int n, char pos1, char pos2, char pos3) {
        if (n == 1) {
            //一个盘子直接从A移到C
            System.out.println(pos1 + "->" + pos3 + " ");
            return;
        }
        //n-1个盘子从A经过C移动到B
        hanoi(n - 1, pos1, pos3, pos2);
        //一个盘子直接从A移到C
        System.out.println(pos1 + "->" + pos3 + " ");
        //n-1个盘子从B经过A移动到C
        hanoi(n - 1, pos2, pos1, pos3);
    }

    public static void main(String[] args) {
        hanoi(4, 'A', 'B', 'C');
    }
}
