class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> row = new ArrayList<Integer>(rowIndex + 1);
        for (int i = 0; i < rowIndex + 1; i++) {
            row.add(combination(rowIndex, i));
        }
        return row;
    }

    private int combination(int n, int k) {
        if (n < k) {
            int temp = k;
            k = n;
            n = temp;
        }
        // (n)! / k!(n-k)!
        // n * n-1 * ... * n-(k-1) / (k-1)!
        double d = 1.0;
        for (int i = 0; i < Math.min(k, n-k); i++) {
            d = d * (n-i) / (i+1);
        }
        System.out.println("Combination: " + n + "C" + k + " = " + d);
        return (int)d;
    }
}

// 0c4, 1c4, 2c4, 3c4, 4c4
// 1    4    6    4    1
// 4 * 3 / 2 * 1