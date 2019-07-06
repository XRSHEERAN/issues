public class Solution {
    /**
     * @param citations: a list of integers
     * @return: return a integer
     */
    public int hIndex(int[] citations) {
        // write your code here
        Arrays.sort(citations);
        int h=citations.length;
        for(int i=0;i<citations.length;++i){
            if(citations[i]>=h){
                return h;
            }
            --h;
        }
        return 0;
    }
}
