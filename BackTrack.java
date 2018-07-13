class Solution {
    private int gl;
    private String str;
    public List<List<String>> solveNQueens(int n) {
        if(n==0)
            return new ArrayList<List<String>>();
        this.gl=n;
        StringBuilder sb=new StringBuilder();
        while(n-->0)
            sb.append('.');
        str=sb.toString();
        List<List<String>> ret=new ArrayList<List<String>>();
        List<String> arrlst=new ArrayList<String>();
        checker(ret,arrlst,0);
        return ret;
    }
    public void checker(List<List<String>> ret,List<String> lst, int lvl){
        //The great thing about using recursive is that you can use the single list without declaring new ones, by removing the item added to list
        if(lvl==gl)
            ret.add(new ArrayList<String>(lst));
        else{
            for(int i=0;i<gl;i++){
                if(valiDefault(lst,lvl,i)){
                    lst.add(str.substring(0,i)+'Q'+str.substring(i+1));
                    checker(ret,lst,lvl+1);
                    lst.remove(lst.size()-1);
                }
            }
        }
    }
    public boolean valiDefault(List<String> lst, int lvl, int col){
        int ld=col-lvl,rd=col+lvl;
        for(int i=0; i<lvl;i++){
            String temp=lst.get(i);
            if(temp.charAt(col)=='Q' || (ld>=0 && temp.charAt(ld)=='Q') || (rd<gl && temp.charAt(rd)=='Q'))
                return false;
            ld++;
            rd--;
        }
        return true;
    }
}
