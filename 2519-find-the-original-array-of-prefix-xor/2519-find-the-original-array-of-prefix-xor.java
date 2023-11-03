class Solution {
    public int[] findArray(int[] pref) {
        if (pref.length == 0) return new int[0];

        int[] result = new int[pref.length];
        result[0] = pref[0];
        for (int i = 1; i < pref.length; i++) {
            result[i] = pref[i-1] ^ pref[i];
        }
        return result;
    }
}