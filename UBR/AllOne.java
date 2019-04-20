class AllOne {
    private class Node{
        //all operations cannot apply to head and tail nodes
        public Node next,prev;
        public int val;
        public HashSet<String> keys;
        public Node(Node prev,Node next, int val){
            this.prev=prev;
            this.next=next;
            this.val=val;
            this.keys=new HashSet<String>();
        }
        public addN(boolean forward, Node n){
            //n already defines with next
            if(forward){
                this.next.prev=n;
                this.next=n;
            }
            else{
                this.prev.next=n;
                this.prev=n;
            }
        }
        public Node remove(String key){
            if(keys.size()==1){
                this.prev.next=this.next;
                this.next.prev=this.prev;
                return this.prev;
            }
            else{
                this.keys.remove(key);
                return this;
            }
        }
    }
    private Node head,tail;
    private HashTable<String,Node> tbl;
    /** Initialize your data structure here. */
    public AllOne() {
        head=new Node(null,null,0);
        tail=new Node(head,null,-1);
        head.next=tail;
        tbl=new HashTable<>();
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if(tbl.containsKey()){
            Node temp=tbl.get(key);
            int val=temp.val+1;
            temp=temp.remove(key);
            if(temp.next.val>val){
                temp.addN(true,new Node(temp,temp.next,val));
                
            }
            temp.next.keys.add(key);
            tbl.put(key,temp.next);
        }
        else{
            if(head.next.val!=1){
                //No one node 
                head.addN(true,new Node(head,head.next,1));
            }
            
            head.next.keys.add(key);
            tbl.put(key,head.next);
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(!tbl.containsKey(key)){
            return;
        }
        Node temp=tbl.get(key);
        int val=temp.val-1;
        temp=temp.remove(key);
        if(temp.val>val){
            temp=temp.prev;
        }
        if(val==0){
            tbl.remove(key);
            return;
        }
        else{
            if(temp.val==val){
                temp.add(key);
            }
            else{
                temp.addN(true,new Node(temp,temp.next,val));
                temp.next.keys.add(key);
            }
        }
        tbl.put(key,temp.next);
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if(tail.prev==head){
            return "";
        }
        return tail.prev.val;
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if(head.next==tail){
            return "";
        }
        return head.next.val;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
