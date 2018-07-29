class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,ArrayList<Integer>> mpP=new HashMap<Integer,ArrayList<Integer>>(); //store the classes require pre
        Map<Integer,ArrayList<Integer>> mpR=new HashMap<Integer,ArrayList<Integer>>(); //store pres
        for(int[] arr : prerequisites){
            if(!mpR.containsKey(arr[1]))
                mpR.put(arr[1],new ArrayList<Integer>());
            if(!mpP.containsKey(arr[0]))
                mpP.put(arr[0],new ArrayList<Integer>());
            mpR.get(arr[1]).add(arr[0]);
            mpP.get(arr[0]).add(arr[1]);
        }
        Set<Integer> counter=new HashSet<Integer>();
        
        for(int i=0;i<numCourses;i++){
            if(!mpP.containsKey(i)){
                depthAdd(counter,mpP,mpR,i);
            }
        }
                

        return (counter.size()==numCourses);
    }
    private void depthAdd(Set<Integer> counter, Map<Integer,ArrayList<Integer>> mpP, Map<Integer,ArrayList<Integer>> mpR, int i){
        if(!counter.add(i) || mpR.get(i)==null)
            return;

        for(int j : mpR.get(i)){
            System.out.println(j);
            if(mpP.get(j)==null)
                continue;
            else if(mpP.get(j).size()==1){
                       

                mpP.put(j,null);
                depthAdd(counter,mpP,mpR,j);
            }
            else{
                mpP.get(j).remove(Integer.valueOf(i));
            }
        }
    }
}
