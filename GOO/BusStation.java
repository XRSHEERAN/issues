public class Solution {
    /**
     * @param N: The number of buses
     * @param route: The route of buses
     * @param A: Start bus station
     * @param B: End bus station
     * @return: Return the minimum transfer number
     */
    public int getMinTransferNumber(int N, int[][] route, int A, int B) {
        // Write your code here
        HashMap<Integer,List<Integer>> tbl=new HashMap<>();
        List<HashSet<Integer>> buses=new ArrayList<>();
        //initial buses crossing table 
        for(int i=0;i<N;++i){
            buses.add(new HashSet<Integer>());
        }
        //update crossing table
        for(int n=0;n<routes.length;++n){
            for(int i:routes[n]){
                if(!tbl.containsKey(i)){
                    List<Integer> temp=new LinkedList<>();
                    temp.add(n);
                    tbl.put(i,temp);//put in new list
                }
                else{
                    for(int j : tbl.get(i)){
                        buses.get(j).add(n);
                        buses.get(n).add(j);//add the crossing info 
                    }
                }
            }
        }
        //go throught the tables
        Queue<int[]> busLine=new LinkedList<>();
        //initialize 
        for(int i:tbl.get(A)){
            busLine.add(new int[]{i,0});//add start 
        }
        //target
        HashSet<Integer> end=new HashSet<>();
        for(int i : tbl.get(B){
            end.add(i);//check the end
        }
        //searching
        while(!busLine.isEmpty()){
            int[] b=busLine.poll();
            if(end.contains(b[0])){
                return b[1]+1;
            }
            if(buses.get(b[0]).size()>0){
                for(int i : buses.get(b[0])){
                    busLine.add(new int[]{i,b[1]+1});
                }
                buses.set(b[0],new ArrayList<Integer>());//remove the lines 
            }
        }
        //if no 
        return -1;
    }
}
