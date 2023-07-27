class Solution {
    public void rotate(int[][] matrix) {
        for (int x1 = 0; x1 <= Math.floor(matrix.length / 2); x1++) {
            for (int y1 = x1; y1 <= matrix[x1].length - x1 - 2; y1++) {
                int x2 = matrix.length - x1 - 1;
                int y2 = matrix.length - y1 - 1;
                // One
                int toSwap = matrix[x1][y1];
                int holder = matrix[y1][x2];
                matrix[y1][x2] = toSwap;
                // Two
                toSwap = holder;
                holder = matrix[x2][y2];
                matrix[x2][y2] = toSwap;
                // Three
                toSwap = holder;
                holder = matrix[y2][x1];
                matrix[y2][x1] = toSwap;
                // Four
                toSwap = holder;
                matrix[x1][y1] = toSwap;
            }
        }
    }
}