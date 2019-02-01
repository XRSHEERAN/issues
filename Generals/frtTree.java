class Solution {
    public int totalFruit(int[] tree) {
        if(tree.length<2){
            return tree.length;
        }
        HashMap<Integer,Integer> tbl=new HashMap<Integer,Integer>(3);
        int ret=0,lft=0;
        for(int i=0;i<tree.length;++i){
            
            if(tbl.containsKey(tree[i])){
                tbl.put(tree[i],tbl.get(tree[i])+1);
            }
            else{
                tbl.put(tree[i],1);
            }
            while(tbl.size()>2){
                int temp=tbl.get(tree[lft])-1;
                if(temp==0){
                    tbl.remove(tree[lft]);
                    ++lft;
                    //System.out.println(lft+","+i);
                    break;
                }
                tbl.put(tree[lft],temp);
                ++lft;
                //System.out.println(lft+","+i);
            }
            ret=Math.max(ret,i-lft+1);
        }
        return ret;
    }
}
