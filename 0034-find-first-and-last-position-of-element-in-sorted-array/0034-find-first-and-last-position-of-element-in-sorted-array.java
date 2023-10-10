class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[] {-1, -1};

        // Edge cases
        if (nums.length == 0) return result;
        if (nums.length == 1) {
            if (nums[0] != target) return result;
            return new int[] {0, 0};
        }


        if (nums[0] == target) {
            result[0] = 0;
        } else {
            // Binary search for target - 0.5
            int leftIndex = binarySearch(nums, target - 0.5) + 1;
            if (nums[leftIndex] != target) {
                // Did not find target
                return new int[] {-1, -1};
            }
            result[0] = leftIndex;
        }

        if (nums[nums.length-1] == target) {
            result[1] = nums.length-1;
        } else {
            // Binary search for target + 0.5
           result[1] = binarySearch(nums, target + 0.5);
        }
        return result;
    }

    // Returns the index of the greatest number smaller than the target
    // Returns -1 if there is no smallest number
    private int binarySearch(int[] nums, double target) {
        int lowIndex = -1;
        int highIndex = nums.length-1;
        int middleIndex = (lowIndex + highIndex) / 2;
        while (highIndex - lowIndex > 1) {
            if (nums[middleIndex] < target) {
                lowIndex = middleIndex;
            } else {
                highIndex = middleIndex;
            }
            middleIndex = (lowIndex + highIndex) / 2;
        }
        return middleIndex;
    }
}