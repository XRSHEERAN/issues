public class Solution {
    /**
     * @param candies: a list of integers
     * @return: return a integer
     */
    public int distributeCandies(int[] candies) {
        // write your code here
        if(candies.length==0){
            return 0;
        }
        HashSet<Integer> tbl=new HashSet<>();
        int max=candies.length/2,curr=candies[0],ret=1;
        tbl.add(curr);
        for(int i=1;i<candies.length;++i){
            if(tbl.add(candies[i])){
                if(ret==max){
                    return ret;
                }
                ++ret;
            }
        }
        return ret;
    }
}
