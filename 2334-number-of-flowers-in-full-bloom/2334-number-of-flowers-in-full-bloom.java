class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        // Sort start times and end times
        int[] sortedStartTimes = new int[flowers.length];
        int[] sortedEndTimes = new int[flowers.length];
        for (int i = 0; i < flowers.length; i++) {
            sortedStartTimes[i] = flowers[i][0];
            sortedEndTimes[i] = flowers[i][1];
        }
        Arrays.sort(sortedStartTimes);
        Arrays.sort(sortedEndTimes);

        // Initialize sorted map of people's arrival times
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int time : people) {
            map.put(time, 0);
        }

        // Use both sorted arrays to find how many flowers are blooming
        int startPointer = 0;
        int endPointer = 0;
        int blooming = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int time = entry.getKey();
            while (startPointer < sortedStartTimes.length && sortedStartTimes[startPointer] <= time) {
                blooming++;
                startPointer++;
            }
            while (endPointer < sortedEndTimes.length && sortedEndTimes[endPointer] < time) {
                blooming--;
                endPointer++;
            }
            map.put(time, blooming);
        }
        
        // Loop through people and copy blooming times from map
        int[] bloomingPerPerson = new int[people.length];
        for (int i = 0; i < people.length; i++) {
            bloomingPerPerson[i] = map.get(people[i]);
        }
        return bloomingPerPerson;
    }
}