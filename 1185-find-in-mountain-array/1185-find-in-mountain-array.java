/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int index = -1;
        if (mountainArr.get(0) <= target) {
            index = findInLeftMountainFace(target, mountainArr);
        }
        if (index == -1 && mountainArr.get(mountainArr.length() - 1) <= target) {
            index = findInRightMountainFace(target, mountainArr);
        }
        return index;
    }


    private int findInLeftMountainFace(int target, MountainArray mountainArr) {
        int leftIndex = 0;
        int rightIndex = mountainArr.length() - 1;

        while (leftIndex <= rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;
            int middleValue = mountainArr.get(middleIndex);
            int middleNextValue = mountainArr.get(middleIndex + 1);

            if (middleValue > middleNextValue) {
                // We are on the right slope
                rightIndex = middleIndex - 1;
            } else {
                // We are on the left (desired) slope
                if (middleValue == target) {
                    return middleIndex;
                } else if (middleValue > target) {
                    rightIndex = middleIndex;
                    return binarySearch(target, mountainArr, leftIndex, rightIndex);
                } else {
                    leftIndex = middleIndex + 1;
                }
            }
        }
        return binarySearch(target, mountainArr, leftIndex, rightIndex);
    }

    private int findInRightMountainFace(int target, MountainArray mountainArr) {
        int leftIndex = 0;
        int rightIndex = mountainArr.length() - 1;

        while (leftIndex <= rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;
            int middleValue = mountainArr.get(middleIndex);
            int middleNextValue = mountainArr.get(middleIndex + 1);

            if (middleValue < middleNextValue) {
                // We are on the left slope
                leftIndex = middleIndex + 1;
            } else {
                // We are on the right (desired) slope
                if (middleValue == target) {
                    return middleIndex;
                } else if (middleValue > target) {
                    leftIndex = middleIndex;
                    return binarySearch(target, mountainArr, leftIndex, rightIndex);
                } else {
                    rightIndex = middleIndex - 1;
                }
            }
        }
        return binarySearch(target, mountainArr, leftIndex, rightIndex);
    }
    

    // Implements a binary search for a mountain array
    // Be sure that leftIndex and rightIndex are on the same side of the mountain array
    // Otherwise, behavior will be unspeicified
    private int binarySearch(int target, MountainArray mountainArr, int leftIndex, int rightIndex) {

        int leftValue = mountainArr.get(leftIndex);
        int rightValue = mountainArr.get(rightIndex);

        while (leftIndex <= rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;
            int middleValue = mountainArr.get(middleIndex);

            if (middleValue == target) {
                return middleIndex;
            }
            
            if (leftValue < rightValue) {
                // Left of mountain peak
                if (middleValue < target) {
                    leftIndex = middleIndex + 1;
                } else {
                    rightIndex = middleIndex - 1;
                }
            } else {
                // Right of mountain peak
                if (middleValue > target) {
                    leftIndex = middleIndex + 1;
                } else {
                    rightIndex = middleIndex - 1;
                }
            }
        }

        if (mountainArr.get(leftIndex) == target) {
            return leftIndex;
        } else if (mountainArr.get(rightIndex) == target) {
            return rightIndex;
        }
        return -1;
    }
}