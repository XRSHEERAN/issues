class Solution {
    public class node{
        public node next;
        public int val;
        public node(int val){
            this.val = val;
            this.next = null;
        }
    }
    public boolean isAlienSorted(String[] words, String order) {
        if(words.length<2){
            return true;
        }
        HashMap<Character, Integer> dic = new HashMap<>();
        for(int i= 0;i<order.length();++i){
            dic.put(order.charAt(i),i);
        }
        int prev = 0;
        node head = new node(-1), curr = head;
        for(String w : words){
            boolean legit = false;
            for(int i=0;i<w.length();++i){
                int temp = dic.get(w.charAt(i));
                if(i>=prev){
                    curr.val = temp;
                    legit = true;
                }
                else if(!legit && curr.val>temp){
                    return false;
                }
                else if(curr.val<temp){
                    legit =true;
                    curr.val = temp;
                }
                
                if(i ==  (w.length()-1) && w.length() == prev){
                    legit =true;
                }
                
                if(curr.next==null && i!=(w.length()-1)){
                        curr.next = new node(-1);
                }
                curr = curr.next;
            }
            if(!legit){
                return false;
            }
            prev = w.length();
            curr = head;
        }
        return true;
    }
}
