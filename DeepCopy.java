/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null)
            return null;
        
        Map<RandomListNode,RandomListNode> mp=new HashMap<RandomListNode,RandomListNode>();
        RandomListNode curr=head;
        RandomListNode temp;
        
        while(curr!=null){
            
            
            if(mp.containsKey(curr)){
                temp=mp.get(curr);
            }
            else{
                temp=new RandomListNode(curr.label);
                mp.put(curr, temp);
            }
            if(curr.next!=null){
                if(mp.containsKey(curr.next))
                    temp.next=mp.get(curr.next);
                else{
                    temp.next=new RandomListNode(curr.next.label);
                    mp.put(curr.next,temp.next);
                }
            }
            if(curr.random!=null){
                if(mp.containsKey(curr.random))
                    temp.random=mp.get(curr.random);
                else{
                    temp.random=new RandomListNode(curr.random.label);
                    mp.put(curr.random,temp.random);
                }
            }
            curr=curr.next;
            
        }
        return mp.get(head);/*
        if (head == null) return null;
  
  Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
  
  // loop 1. copy all the nodes
  RandomListNode node = head;
  while (node != null) {
    map.put(node, new RandomListNode(node.label));
    node = node.next;
  }
  
  // loop 2. assign next and random pointers
  node = head;
  while (node != null) {
    map.get(node).next = map.get(node.next);
    map.get(node).random = map.get(node.random);
    node = node.next;
  }
  
  return map.get(head);*/
    }
    private void updateCurr(Map<RandomListNode,RandomListNode> mp, RandomListNode curr, RandomListNode temp){
        if(mp.containsKey(curr)){
            temp=mp.get(curr);
        }
        else{
            mp.put(curr, temp);
        }
    }
}
