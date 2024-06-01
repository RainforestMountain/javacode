package test3;

public class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        int[] netGas = new int[n];
        for (int j = 0; j < n; j++) {
            netGas[j] = gas[j] - cost[j];
        }
        while (i < n) {
            int sum_gas = 0;
            int cnt = 0;
            while (cnt < n) {
                int j = (i + cnt) % n;
                sum_gas += netGas[j];
                if (sum_gas < 0) {
                    break;
                }
                cnt++;
            }
            if (cnt == n) {
                return i;
            } else {
                i = i + cnt + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.canCompleteCircuit(
//                new int[]{5, 1, 2, 3, 4}, new int[]{4, 4, 1, 5, 1}));
        System.out.println(solution.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
    }
}
