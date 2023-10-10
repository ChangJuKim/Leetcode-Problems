class Solution {
    public int minOperations(int[] nums) {
        if (nums.length <= 1) return 0;

        // Sort the array
        Arrays.sort(nums);

        // Remove duplicates
        ArrayList<Integer> numsWithoutDuplicates = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                numsWithoutDuplicates.add(nums[i]);
            }
        }

        // Loop through array
        int leftPointer = 0;
        int rightPointer = 1;
        int biggestWindowSizeFound = 1;
        while (rightPointer < numsWithoutDuplicates.size()) {
            // Check how many non-duplicate values are in the sliding window
            int leftNum = numsWithoutDuplicates.get(leftPointer);
            int rightNum = numsWithoutDuplicates.get(rightPointer);
            int maxWindowValue = leftNum + nums.length - 1;
            
            if (rightNum <= maxWindowValue) {
                biggestWindowSizeFound = Math.max(biggestWindowSizeFound, rightPointer - leftPointer + 1);
                rightPointer += 1;
            } else {
                leftPointer += 1;
            }
        }

        return nums.length - biggestWindowSizeFound;
    }
}