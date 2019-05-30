/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    /**
     * @param n a party with n people
     * @return the celebrity's label or -1
     */
    public int findCelebrity(int n) {
        if(n<2){
            return 0;
        }
        // Write your code here
        List<Integer> cand=new LinkedList<>();
        HashMap<Integer,Integer> tbl=new HashMap<>();
        for(int i=0;i<n;++i){
            tbl.put(i,0);
            int count=0;
            for(int j=0;j<n;++j){
                if(j!=i && knows(i,j)){
                    ++count;
                }
                if(j!=i && knows(j,i)){
                    tbl.put(i,tbl.get(i)+1);
                }
            }
            if(count==0){
                cand.add(i);
            }
        }
        for(int i : cand){
            if(tbl.get(i)==n-1){
                return i;
            }
        }
        return -1;
    }
}
