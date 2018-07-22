
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals.size()==0){
            List<Interval> tmp=new ArrayList<Interval>();
            tmp.add(newInterval);
            return tmp;
        }
        for(int i=0;i<intervals.size();i++){
            Interval tempi=intervals.get(i);
            if(newInterval.end<tempi.start){
                intervals.add(i,newInterval);
                break;
            }
            else if(newInterval.start>tempi.end){
                if(i==intervals.size()-1)
                    intervals.add(newInterval);
                continue;
            }
            else{
                merge(i,intervals,newInterval);
                break;
            }
                
        }
        return intervals;
    }
    private void merge(int loc, List<Interval> intervals, Interval newInterval){
        int currS=newInterval.start,
        currE=newInterval.end;
        
        Interval temp=intervals.get(loc);
        
        while(newInterval.end>=temp.start && newInterval.start<=temp.end){
                    
            currS=Math.min(currS, temp.start);
            currE=Math.max(currE, temp.end);
            intervals.remove(loc);
            if(loc==intervals.size())
                break;
            temp=intervals.get(loc);
        }
        
        intervals.add(loc,new Interval(currS,currE));
    }
}
