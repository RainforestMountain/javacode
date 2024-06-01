import java.util.Arrays;

public class WanderTest {
    /**
     * 编写程序，生成一个跨越10×10字符数组（元素的初值都为’.’）的“随机漫步”。
     * 程序必须随机地从一个元素“走到”另一个元素，
     * 每次都向上、向下、向左或向右移动一个元素位置。0 , 1 , 2 ,3 代表上下左右，Math.random()方法
     * 已访问过的元素按访问顺序用字母A到Z进行标记。
     * 一是不能走到数组外面，二是不能走到已有字母标记的位置。只要有一个条件不满足，
     * 就需尝试换一个方向移动。如果4个方向都堵住了，程序终止
     *
     * @param x
     * @param y
     */
    public static void randomWander(int x, int y, char[][] data) {
        for (char[] datum : data) {
            Arrays.fill(datum, '.');
        }
        //字母标记数组
        char[] flag = new char[26];
        int order = 0;
        for (int i = 0; i < flag.length; i++) {
            flag[i] = (char) ('A' + i);
        }
        while (true) {
            int moveWay = (int) (Math.random() * 4);
            //用于确定这个位置上已经移动过的方向
            int[] moveFlag = new int[4];
            if (moveFlag[moveWay] == 0) {
                switch (moveWay) {
                    case 0 -> {
                        //移动
                        x--;
                        //检查是否可以移动，这个位置堵没堵
                        if (checkIndex(x, y, data)) {
                            data[x + 1][y] = flag[order];
                            order++;
                            //成功移动，位置改变，要重置每个方向
                            Arrays.fill(moveFlag, 0);
                        } else {
                            //堵了移动回去
                            x++;
                            //这个方向不可移动
                            moveFlag[0] = 1;
                        }
                    }
                    case 1 -> {
                        //移动
                        x++;
                        //检查是否可以移动，这个位置堵没堵
                        if (checkIndex(x, y, data)) {
                            data[x - 1][y] = flag[order];
                            order++;
                            //成功移动，位置改变，要重置每个方向
                            Arrays.fill(moveFlag, 0);
                        } else {
                            //堵了移动回去
                            x--;
                            //这个方向不可移动
                            moveFlag[1] = 1;
                        }
                    }
                    case 2 -> {
                        //移动
                        y--;
                        //检查是否可以移动，这个位置堵没堵
                        if (checkIndex(x, y, data)) {
                            data[x][y + 1] = flag[order];
                            order++;
                            //成功移动，位置改变，要重置每个方向
                            Arrays.fill(moveFlag, 0);
                        } else {
                            //堵了移动回去
                            y++;
                            //这个方向不可移动
                            moveFlag[2] = 1;
                        }
                    }
                    case 3 -> {
                        //移动
                        y++;
                        //检查是否可以移动，这个位置堵没堵
                        if (checkIndex(x, y, data)) {
                            data[x][y - 1] = flag[order];
                            order++;
                            //成功移动，位置改变，要重置每个方向
                            Arrays.fill(moveFlag, 0);
                        } else {
                            //堵了移动回去
                            y--;
                            //这个方向不可移动
                            moveFlag[3] = 1;
                        }
                    }
                }
            }
            if (moveFlag[0] + moveFlag[1] + moveFlag[2] + moveFlag[3] == 4) {
                //全部方向都是堵的
                break;
            }
            //检查是否结束移动
            if (isEndMove(x, y, data, order)) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        char[][] data = new char[10][10];
        //参数x,y为数组下标
        randomWander(0, 0, data);
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }

    //检查是否可以移动，这个位置堵没堵
    public static boolean checkIndex(int x, int y, char[][] data) {
        if (x < 0 || x >= data.length || y < 0 || y >= data[0].length) {
            return false;
        }
        if (data[x][y] != '.') {
            return false;
        }
        return true;
    }

    //检查是否结束移动
    public static boolean isEndMove(int x, int y, char[][] data, int order) {
        int x0 = x - 1, y0 = y;
        int x1 = x + 1, y1 = y;
        int x2 = x, y2 = y - 1;
        int x3 = x, y3 = y + 1;
        if (order == 26) {
            return true;
        }
        if (checkIndex(x0, y0, data)) {
            return false;
        } else if (checkIndex(x1, y1, data)) {
            return false;
        } else if (checkIndex(x2, y2, data)) {
            return false;
        } else if (checkIndex(x3, y3, data)) {
            return false;
        } else {
            return true;
        }

    }


}
