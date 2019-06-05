class Solution {
    public String getHint(String secret, String guess) {
        HashSet<Character> hst=new HashSet<>();
        HashMap<Character,Integer> chst=new HashMap<>();
        List<Character> lst=new LinkedList<>();
        int bull=0,cow=0;
        for(int i=0;i<secret.length();++i){
            if(secret.charAt(i)==guess.charAt(i)){
                hst.add(secret.charAt(i));
                ++bull;
            }
            else{
                lst.add(guess.charAt(i));
                chst.put(secret.charAt(i),chst.getOrDefault(secret.charAt(i),0)+1);
            }
        }
        for(char i:lst){
            if(chst.containsKey(i)){
                int curr=chst.get(i);
                ++cow;
                if(curr==1){
                    chst.remove(i);
                }
                else{
                    chst.put(i,curr-1);
                }
            }
        }
        return bull+"A"+cow+"B";
    }
}
