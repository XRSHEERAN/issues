### First Meeting, determine if person can take all

```
/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return Integer.compare(a.start, b.start);
            }
        });
        int prev = 0;
        for(int i=0;i<intervals.size(); ++i){
            Interval curr = intervals.get(i);
            if(prev> curr.start){
                return false;
            }
            prev = curr.end;
        }
        return true;
    }
}
```
