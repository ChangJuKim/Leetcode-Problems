class Solution {
    public List<String> buildArray(int[] target, int n) {
        final String PUSH = "Push";
        final String POP = "Pop";

        if (target.length == 0) {
            return new ArrayList<String>();
        }

        ArrayList<String> arrayToBuild = new ArrayList<String>(target.length);
        final int MAX_VALUE = target[target.length - 1];
        int currentStreamInt = 1;
        for (int next : target) {
            while (currentStreamInt <= MAX_VALUE && currentStreamInt != next) {
                arrayToBuild.add(PUSH);
                arrayToBuild.add(POP);
                currentStreamInt++;
            }
            if (currentStreamInt == next) {
                arrayToBuild.add(PUSH);
                currentStreamInt++;
            }
        }

        return arrayToBuild;
    }
}