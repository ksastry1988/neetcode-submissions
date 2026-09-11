/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) return 0;

        int[] starts = new int[intervals.size()];
        int[] ends = new int[intervals.size()];

        for(int i = 0; i< intervals.size(); i++){
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int i = 0, j = 0;
        int maxRooms = 0, rooms = 0;

        while (starts.length > i && ends.length > j){
            if (starts[i] < ends[j]){
                rooms++;
                maxRooms = Math.max(rooms, maxRooms);
                i++;
            }
            else{
                rooms --;
                j++;
            }
        }
        return maxRooms;
    }
}
