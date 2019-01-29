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
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        List<Integer> strtL=new ArrayList<Integer>(), endL=new ArrayList<Integer>();
        for(Interval temp : intervals){
            strtL.add(temp.start);
            endL.add(temp.end);
        }
        Collections.sort(strtL);
        Collections.sort(endL);
        int ptr=0,curr=0,currM=0;
        for(int i=0;i<strtL.size();++i){
            if(strtL.get(i)<endL.get(ptr)){
                currM=Math.max(++curr,currM);
            }
            else{
                while(ptr<endL.size() && endL.get(ptr)<=strtL.get(i)){
                    --curr;
                    ++ptr;
                }
                --i;
            }
        }
        return currM;
    }
}
