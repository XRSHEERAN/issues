public class WordDictionary {
    private class trie{
        public HashTable<Character,trie> tbl;
        public boolean isFinal;
        public trie(){
            tbl=new HashTable<>();
        }
    }
    public trie head=new trie();
    /*
     * @param word: Adds a word into the data structure.
     * @return: nothing
     */
    public void addWord(String word) {
        // write your code here
        trie curr=head;
        for(int i=0;i<word.length();++i){
            if(!curr.tbl.containsKey(word.charAt(i))){
                curr.put(word.charAt(i),new trie());
            }
            curr=curr.get(word.charAt(i));
        }
    }

    /*
     * @param word: A word could contain the dot character '.' to represent any one letter.
     * @return: if the word is in the data structure.
     */
    public boolean search(String word) {
        // write your code here
        return helper(word,head,0);
    }
    private boolean helper(String s, trie curr, int p){
        if(curr=null){
            return false;
        }
        if(curr.isFinal){
            return true;
        }
        
        if(s.charAt(p)=='.'){
            bool temp=false;
            for(trie t : curr.tbl.valueSet()){
                temp=helper(s,t,p+1);
                if(temp){
                    return true;
                }
            }
        }
        else{
            return helper(s,curr.get(s.charAt(p)),p+1);
        }
        return false;
    }
}
