/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param intervals: Sorted interval list.
     * @param newInterval: new interval.
     * @return: A new interval list.
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        // write your code here
        int ptr=0;
        List<Interval> ret=new ArrayList<Interval>();
        
        while(ptr<intervals.size() && intervals.get(ptr).end<newInterval.start){
            ret.add(intervals.get(ptr));
            ++ptr;
        }
        
        if(ptr==intervals.size()){
            ret.add(newInterval);
            return ret;
        }
        int newS=newInterval.start,newE=newInterval.end;
        while(ptr<intervals.size() && intervals.get(ptr).start<=newE){
            newS=Math.min(intervals.get(ptr).start,newS);
            newE=Math.max(intervals.get(ptr).end,newE);
            ++ptr;
        }
        ret.add(new Interval(newS,newE));
        while(ptr<intervals.size()){
            ret.add(intervals.get(ptr));
            ++ptr;
        }
        return ret;
    }
}
