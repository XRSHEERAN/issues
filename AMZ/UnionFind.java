public class Solution {
    /**
     * @param edges: List[List[int]]
     * @return: List[int]
     */
     public class Node{
         public Node ances;
         public int val;
         public Node(int n){
             val=n;
             ances=this;
         }
         public Node findR(){
             Node temp=this.ances;
             
             while(temp.ances!=temp){
                 temp=temp.ances;
             }
             return temp;
         }
         public void union(Node a){
             a.findR().ances=this.findR();
         }
     }
    public int[] findRedundantConnection(int[][] edges) {
        // write your code here
        HashMap<Integer,Node> tbl=new HashMap<Integer,Node>();
        int [] ret=new int[2];
        for(int[] edg : edges){
            Node l=tbl.getOrDefault(edg[0],new Node(edg[0]));
            Node r=tbl.getOrDefault(edg[1],new Node(edg[1]));
            tbl.put(edg[0],l);
            tbl.put(edg[1],r);
            if(l.findR()==r.findR()){
                ret=edg;
            }
            else{
                l.union(r);
            }
        }
        return ret;
    }
}
