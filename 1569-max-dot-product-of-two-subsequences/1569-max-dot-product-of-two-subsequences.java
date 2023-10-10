class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return 0;
        }

        int[][] memo = new int[nums1.length][nums2.length];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                int cellValue = nums1[i] * nums2[j];
                cellValue = findGreatestCellValue(cellValue, memo, i, j);
                memo[i][j] = cellValue;
            }
        }
        return memo[nums1.length-1][nums2.length-1];
    }

    private int findGreatestCellValue(int currentValue, int[][] memo, int i, int j) {
        if (i > 0 && j > 0) {
            if (memo[i-1][j-1] >= 0) {
                currentValue += memo[i-1][j-1];
            }
        }
        if (i > 0) {
            currentValue = Math.max(currentValue, memo[i-1][j]);
        }
        if (j > 0) {
            currentValue = Math.max(currentValue, memo[i][j-1]);
        }
        return currentValue;
    }
}

/*
1, 4, 6, 2, 3
1, 5, 3

4, 6, 3 | 1, 5, 3 
= 4 + 30 + 9 
= 43

    1  4  6  2  3

1|  1  4  6  6  6
5|  5  21 34 34 34
3|  5  17 39 40 43

43

2, 1, -2, 5
3, 0, 6

    2  1  -2 5
3   6  6  6  15
0   6  6  6  15
-6  6  6  18 18
*/