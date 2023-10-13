class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 0) return 0;
        if (cost.length == 1) return cost[0];
        int[] memo = new int[cost.length];
        memo[0] = cost[0];
        memo[1] = cost[1];
        for (int i = 2; i < memo.length; i++) {
            memo[i] = Math.min(memo[i-2], memo[i-1]) + cost[i];
        }
        return Math.min(memo[memo.length - 1], memo[memo.length - 2]);
    }
}