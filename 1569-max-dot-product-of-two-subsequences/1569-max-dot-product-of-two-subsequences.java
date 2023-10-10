class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return 0;
        }

        // We only need to store 2 rows of memory as we are only checking
        // up, left and diagonally up-left
        int[][] memo = new int[2][nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < memo[0].length; j++) {
                int cellValue = findGreatestCellValue(nums1, nums2, memo, i, j);
                memo[getCurrentRowIndex(i)][j] = cellValue;
            }
        }
        return memo[getCurrentRowIndex(nums1.length - 1)][nums2.length-1];
    }

    private int findGreatestCellValue(int[] nums1, int[] nums2, int[][] memo, int i, int j) {
        int currentValue = nums1[i] * nums2[j];
        if (i > 0 && j > 0) {
            if (memo[getPreviousRowIndex(i)][j-1] >= 0) {
                currentValue += memo[getPreviousRowIndex(i)][j-1];
            }
        }

        // Check if skipping nums1[i] gives a greater result
        if (i > 0) {
            int row = getPreviousRowIndex(i);
            currentValue = Math.max(currentValue, memo[row][j]);
        }
        // Check if sipping nums2[j] gives a greater result
        if (j > 0) {
            int row = getCurrentRowIndex(i);
            currentValue = Math.max(currentValue, memo[row][j-1]);
        }
        // Return greatest value
        return currentValue;
    }

    private int getCurrentRowIndex(int i) {
        return i % 2;
    }

    private int getPreviousRowIndex(int i) {
        return (i+1) % 2;
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