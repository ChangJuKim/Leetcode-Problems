class Solution {
    public int uniquePaths(int m, int n) {
        int ROW = m-1;
        int COL = n-1;
        int[] our_row = new int[n];
        our_row[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j+1 < n) {
                    our_row[j+1] += our_row[j];
                }
            }
        }
        return our_row[n-1];
    }
}