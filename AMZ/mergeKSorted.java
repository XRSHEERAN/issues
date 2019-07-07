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
     * @param intervals: the given k sorted interval lists
     * @return:  the new sorted interval list
     */
    public List<Interval> mergeKSortedIntervalLists(List<List<Interval>> intervals) {
        // write your code here
        PriorityQueue<Interval> q=new PriorityQueue<Interval>(new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.start-b.start;
            }
            });
        for(List<Interval> l : intervals){
            for(Interval i : l){
                q.add(i);
            }
        }
        List<Interval> ret=new LinkedList<>();
        if(q.isEmpty()){
            return ret;
        }
        Interval curr=new Interval(q.peek().start,q.peek().end);
        q.poll();
        while(!q.isEmpty()){
            Interval i=q.poll();
            if(curr.end >= i.start){
                curr.end=Math.max(curr.end,i.end);
            }
            else{
                ret.add(curr);
                curr=new Interval(i.start,i.end);
                
            }
            if(q.isEmpty()){
                    ret.add(curr);
            }
        }
        return ret;
    }
}
