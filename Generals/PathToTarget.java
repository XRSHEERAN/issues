public class Solution {
    /**
     * @param graph: a 2D array
     * @return: all possible paths from node 0 to node N-1
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // Write your code here
        if(graph.length==0){
            return new ArrayList<List<Integer>>();
        }
        //DFS
        List<List<Integer>> ret=new LinkedList<>();
        List<Integer> p=new LinkedList<Integer>();
        p.add(0);
        dfs(ret,p,graph);
        return ret;
    }
    private void dfs(List<List<Integer>> ret, List<Integer> path, int[][] graph){
        int curr=path.get(path.size()-1);
        
        for(int i:graph[curr]){
            path.add(i);
            if(i==graph.length-1){
                ret.add(new LinkedList<Integer>(path));
                
            }
            else{
                dfs(ret,path,graph);
            }
            path.remove(path.size()-1);
        }
        
    }
}
