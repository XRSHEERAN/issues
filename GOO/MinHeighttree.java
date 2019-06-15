class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1){
            List<Integer> l=new LinkedList<Integer>();
            l.add(0);
            return l;
        }
        //1.get all neighbors
        List<HashSet<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;++i){
            adj.add(new HashSet<Integer>());
        }
        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        //2.put leaves to queue
        Queue<Integer> q=new LinkedList<Integer>();
        for(int i=0;i<adj.size();++i){
            if(adj.get(i).size()==1){
                q.add(i);
            }
        }
        //3.loop until two or 1 root(s) left
        int count=n;
        while(count>2){
            count-=q.size();
            int round=q.size();
            while(round>0){
                int curr=q.poll(), neighbor=adj.get(curr).iterator().next();
                adj.get(neighbor).remove(curr);
                if(adj.get(neighbor).size()==1){
                    q.add(neighbor);
                }
                --round;
            }
        }
        return new LinkedList<Integer>(q);
    }
}
