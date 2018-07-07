class Solution {
    public List<List<Integer>> generate(int numRows) {
        if(numRows==0)
            return new ArrayList();
        Queue<List<Integer>> tbl=new LinkedList<List<Integer>>();
        List<Integer> lst=new ArrayList<Integer>();
        lst.add(1);
        tbl.add(lst);
        
        for(int i=1;i<numRows;i++){
            lst=new ArrayList<Integer>();
            lst.add(1);
            List<Integer> formal=((LinkedList<List<Integer>>)tbl).getLast();
            for(int j=0;j+1<formal.size();j++)
                lst.add(formal.get(j)+formal.get(j+1));
            lst.add(1);
            tbl.add(lst);
        }
        
        return (List)tbl;
    }
}
