class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        Map<Integer, Integer> binaryToIndex = new HashMap<>();
        Map<Integer, Integer> indexToBinary = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            int binary = convertToBinary(cells);
            
            if (binaryToIndex.containsKey(binary)) {
                int loopStart = binaryToIndex.get(binary);
                int loopSize = i - loopStart;
                int remainingDays = n - i;
                
                int index = loopStart + remainingDays % loopSize;
                
                int[] result = binaryToCell(indexToBinary.get(index));
                System.out.println(Arrays.toString(result));
                return result;
            } else {
                binaryToIndex.put(binary, i);
                indexToBinary.put(i, binary);
            }
            getNextState(cells);
            
        }
        
        return cells;
    }
    
    private int convertToBinary(int[] cells) {
        int total = 0;
        int multipleTwo = 1;
        for (int cell : cells) {
            total += multipleTwo * cell;
            multipleTwo *= 2;
        }
        return total;
    }
    
    private int[] binaryToCell(int binary) {
        int[] result = new int[8];
        for (int i = 0; i < 8; i++) {
            result[i] = binary % 2;
            binary /= 2;
        }
        return result;
    }
    
    private void getNextState(int[] cells) {
        int prev = cells[0];
        for (int i = 1; i < cells.length - 1; i++) {
            int temp = cells[i];
            cells[i] = (prev == cells[i+1]) ? 1 : 0;
            prev = temp;
        }
        cells[0] = 0;
        cells[cells.length - 1] = 0;
    }
}

/*
n = 18

 1: 32
 2: 15
 3: 23
 4: 10
 5: 2
 6: 5
 7: 19
 8: 4
 9: 23      loopsize = 9-3 = 6
10: 10      remaining = 18-9 = 9
            loopStart = 3
11: 2       index = loopStart + remaining % loopsize = 3 + 9 % 6 = 6 
12: 5
13: 19
14: 4
15: 23
16: 10
17: 2
18: 5
19: 19

13: answer = 19

Day 0:  [0, 1, 0, 1, 1, 0, 0, 1]
Day 1:  [0, 1, 1, 0, 0, 0, 0, 0]
Day 2:  [0, 0, 0, 0, 1, 1, 1, 0]
Day 3:  [0, 1, 1, 0, 0, 1, 0, 0]
Day 4:  [0, 0, 0, 0, 0, 1, 0, 0]
Day 5:  [0, 1, 1, 1, 0, 1, 0, 0]
Day 6:  [0, 0, 1, 0, 1, 1, 0, 0]
Day 7:  [0, 0, 1, 1, 0, 0, 0, 0]
Day 8:  [0, 0, 0, 0, 0, 1, 1, 0]
Day 9:  [0, 1, 1, 1, 0, 0, 0, 0]
Day 10: [0, 0, 1, 0, 0, 1, 1, 0]
Day 11: [0, 0, 1, 0, 0, 0, 0, 0]
Day 12: [0, 0, 1, 0, 1, 1, 1, 0]
Day 13: [0, 0, 1, 1, 0, 1, 0, 0]
Day 14: [0, 0, 0, 0, 1, 1, 0, 0]
Day 15: [0, 1, 1, 0, 0, 0, 0, 0]

*/