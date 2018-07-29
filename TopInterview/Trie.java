class Trie {
/* very slow
    /** Initialize your data structure here. 
    private Set<String> st;
    public Trie() {
        st=new HashSet<String>();
    }
    
    /** Inserts a word into the trie. 
    public void insert(String word) {
        st.add(word);
    }
    
    /** Returns if the word is in the trie. 
    public boolean search(String word) {
        return st.contains(word);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. 
    public boolean startsWith(String prefix) {
        for(String s : st){
            if(s.startsWith(prefix))
                return true;
        }
        return false;
    }
}
*/
    private HashMap<Character,Trie> mp; //avoid new class, keep Trie as node
    private boolean stp;
    public Trie() {
        this.mp=new HashMap<Character,Trie>();
        this.stp=false;
    }
    
    /** Inserts a word into the trie.**/ 
    public void insert(String word) {
        Trie curr=this;
        for(char i : word.toCharArray()){
            if(!curr.mp.containsKey(i))
                curr.mp.put(i,new Trie());
            curr=curr.mp.get(i);
        }
        curr.stp=true;
    }
    
    /** Returns if the word is in the trie. **/
    public boolean search(String word) {
        return searchHelper(word,this,true);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. **/
    public boolean startsWith(String prefix) {
        return searchHelper(prefix,this,false);
    }
    
    private boolean searchHelper(String word, Trie itr, boolean partial){
        for(char i : word.toCharArray()){
            if(!itr.mp.containsKey(i))
                return false;
            itr=itr.mp.get(i);
        }
        if(partial)
            return itr.stp;
        return true;
    }
}
    
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
