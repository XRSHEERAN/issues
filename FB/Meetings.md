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

## Meeting II
```
public int greedyMethod(List<Interval> intervals){
        if(intervals.size()==0){
            return 0;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        // sort the intervals as if the later cannot fit then the earlier cannot fit. if they both can fit, then it doesn't matter as either they'll create a new room with ending time all in or they all fit with all end time in the PriorityQueue
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.start - b.start;
            }
        });
        int count =1;
        minHeap.add(intervals.get(0).end);
        for(int i=1;i<intervals.size();++i){
            Interval curr = intervals.get(i);
            int bound = minHeap.peek();
            if(bound>curr.start){
                ++count;// new room added
            }else{
                minHeap.poll();
            }
            minHeap.add(curr.end);
        }
        return count;
    }
    
    public int stateCounter(List<Interval> intervals){
        // maintain a state tracker and see what's the instant highest number of usage
        TreeMap<Integer,Integer> tbl = new TreeMap<>();
        // put new room request as 1 (start time) and cancel room request as -1 (end time)
        for(Interval i : intervals){
            tbl.put(i.start, tbl.getOrDefault(i.start,0)+1);
            tbl.put(i.end, tbl.getOrDefault(i.end,0)-1);
        }
        int roomCount = 0, ret = 0;
        for(Map.Entry<Integer,Integer> e : tbl.entrySet()){
            roomCount+=e.getValue();
            ret = Math.max(roomCount, ret);
        }
        return ret;
        
    }
```
