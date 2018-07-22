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


//a better way FYI
class Solution {
    private int count;
    private HashSet<Integer> colS;
    private HashSet<Integer> ldS;
    private HashSet<Integer> rdS;
    private int gl;
    public int totalNQueens(int n) {
        if(n==0)
            return 0;
        colS=new HashSet<Integer>();
        ldS=new HashSet<Integer>();
        rdS=new HashSet<Integer>();
        count=0;
        gl=n;
        tracking(0);
        return count;
    }
    public void tracking(int lvl){
        if(lvl==gl)
            this.count++;
        //Here is the trick, for col set, the col number is unique; left diagnal, row-col is constant; right diagnal, sum is constant
        for(int i=0;i<gl;i++){
            if(!colS.contains(i) && !ldS.contains(lvl-i) && !rdS.contains(i+lvl)){
                colS.add(i);ldS.add(lvl-i);rdS.add(i+lvl);
                tracking(lvl+1);
                colS.remove(i);
                ldS.remove(lvl-i);
                rdS.remove(i+lvl);
            }
        }
    }
}
