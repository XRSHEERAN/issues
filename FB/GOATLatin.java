public class Solution {
    /**
     * @param S: 
     * @return: nothing
     */
    public String  toGoatLatin(String S) {
        HashSet<Character> vow=new HashSet<>(Arrays.asList('a','e','i','o','u','O','I','A','E','U'));
        String[] sp=S.split(" ");
        StringBuilder sb=new StringBuilder();
        String ap="a";
        for(String s : sp){
            String ns="";
            if(vow.contains(s.charAt(0))){
                ns+=s+"ma"+ap;
            }
            else{
                ns=s.substring(1)+s.charAt(0)+"ma"+ap;
            }
            ap+='a';
            sb.append(ns);
            sb.append(' ');
        }
        return sb.substring(0,sb.length()-1).toString();
    }
}
