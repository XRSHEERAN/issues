class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] preCounts=new int[numCourses],ret=new int[numCourses];
        HashMap<Integer,List<Integer>> intMap=new HashMap<Integer,List<Integer>>();
        for(int[] arr : prerequisites){
            preCounts[arr[0]]++;
            if(!intMap.containsKey(arr[1]))
                intMap.put(arr[1],new ArrayList<Integer>());
            intMap.get(arr[1]).add(arr[0]);
        }
        int itr=0;
        Queue<Integer> lst=new LinkedList<Integer>();
        for(int i=0;i<numCourses;i++){
            if(preCounts[i]==0)
                lst.add(i);
            
        }
        while(!lst.isEmpty()){
            int curr=lst.poll();
            ret[itr++]=curr;
            if(intMap.containsKey(curr))
                for(int i : intMap.get(curr)){
                    if(preCounts[i]==1)
                        lst.add(i);
                    else
                        preCounts[i]--;
                }
        }
        if(itr<numCourses-1)
            return new int[0];
        return ret;
    }
}
