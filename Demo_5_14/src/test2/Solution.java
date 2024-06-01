package test2;

import java.util.Random;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        long seed = System.currentTimeMillis();
        Random random = new Random(seed);
        Scanner scanner = new Scanner(System.in);
        double radius = scanner.nextDouble();
        int count_rectangle = 0;
        int count_cricle = 0;

        for (int i = 0; i < 100000000; i++) {
            double x = random.nextDouble(-radius, radius);
            double y = random.nextDouble(-radius, radius);
            //统计
            if ((x * x + y * y) <= radius * radius) {
                count_cricle++;
            }
            count_rectangle++;
        }
        System.out.println(count_cricle * 1.0 / count_rectangle * 4);
    }
}
