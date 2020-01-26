package LeetCode;

public class LC134_Gas_Station {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int curTank = 0;
            int totalTank = 0;
            int start = 0;
            for (int i = 0; i < gas.length; i++) {
                curTank += gas[i] - cost[i];
                totalTank += gas[i] - cost[i];
                if (curTank < 0) {
                    start = i + 1;
                    curTank = 0;
                }
            }
            return totalTank >= 0 ? start : -1;
        }
}
