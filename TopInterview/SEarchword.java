class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        trie root=new trie();
        for(String s : words)
            root.insert(s);
        List<String> ret=new ArrayList<String>();
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++){
                searchCurr(board,root,i,j,ret);
            }
        return ret;
    }
    private void searchCurr(char[][]board,trie root, int i, int j, List<String>ret){
        
        if(root.word!=null){
            
            if(!ret.contains(root.word))ret.add(root.word);
        }
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]=='.' || !root.mp.containsKey(board[i][j])) return;
             
        
        char temp=board[i][j];
        board[i][j]='.';
        searchCurr(board,root.mp.get(temp),i+1,j,ret);
        searchCurr(board,root.mp.get(temp),i-1,j,ret);
        searchCurr(board,root.mp.get(temp),i,j+1,ret);
        searchCurr(board,root.mp.get(temp),i,j-1,ret);
        board[i][j]=temp;
    }
    private class trie{
        private String word;
        private HashMap<Character,trie> mp;
        
        public trie(){
            mp=new HashMap<Character,trie>();
            word=null;
        }
        
        public void insert(String s){
            trie temp=this;
            for(char c : s.toCharArray()){
                if(!temp.mp.containsKey(c))
                    temp.mp.put(c,new trie());
                temp=temp.mp.get(c);
            }
            temp.word=s;
        }
    }
}
