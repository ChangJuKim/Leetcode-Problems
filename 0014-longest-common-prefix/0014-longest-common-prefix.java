class Solution {
    public String longestCommonPrefix(String[] strs) {
        /*
            Have prefix string = strs[0]
            As i loop through strings, shorten prefix if necessary
        */

        if (strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String currentString = strs[i];
            for (int j = 0; j < Math.min(prefix.length(), currentString.length()); j++) {
                if (prefix.charAt(j) != currentString.charAt(j)) {
                    prefix = prefix.substring(0, j);
                }
            }
            prefix = prefix.substring(0, Math.min(prefix.length(), currentString.length()));
        }
        return prefix;

    }
}