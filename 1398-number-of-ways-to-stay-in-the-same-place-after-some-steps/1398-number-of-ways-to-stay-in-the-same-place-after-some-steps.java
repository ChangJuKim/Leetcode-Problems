class Solution {
    private int MODULO_CONSTANT = (int)(Math.pow(10, 9) + 7);

    public int numWays(int steps, int arrLen) {
        int[][] waysToZero = new int[2][arrLen];
        waysToZero[0][0] = 1;

        for (int step = 0; step < steps; step++) {
            int oldIndex = step % 2;
            int newIndex = (step + 1) % 2;
            for (int index = 0; index < arrLen; index++) {
                int numWays = waysToZero[oldIndex][index];
                if (index != 0) {
                    numWays = sumWithModulo(numWays, waysToZero[oldIndex][index-1]);
                }
                if (index != arrLen - 1) {
                    numWays = sumWithModulo(numWays, waysToZero[oldIndex][index+1]);
                }
                //System.out.println("STEP " + step + " => " + numWays);
                waysToZero[newIndex][index] = numWays;
            }
        }

        return waysToZero[steps % 2][0];
    }

    private int sumWithModulo(int num1, int num2) {
/*
        while (MODULO_CONSTANT - num1 >= num2) {
            num2 = num2 - MODULO_CONSTANT;
        }
        */
        //int sum = ((num1 % MODULO_CONSTANT) + (num2 % MODULO_CONSTANT)) % MODULO_CONSTANT;
        int sum = (num1 + num2) % MODULO_CONSTANT;
        return sum;
    }
}