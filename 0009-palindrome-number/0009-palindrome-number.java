class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        Stack<Integer> stack = new Stack<>();

        String stringVersion = "" + x;
        int length = stringVersion.length();

        // Push right half into stack
        for (int i = 0; i < length / 2; i++) {
            stack.push(x % 10);
            x = x / 10;
        }
        
        // Get rid of middle element
        if (length % 2 == 1) {
            x = x / 10;
        }

        // Verify left half with right half
        for (int i = 0; i < length / 2; i++) {
            if (stack.pop() != x % 10) {
                return false;
            }
            x = x / 10;
        }
        return true;
    }
}