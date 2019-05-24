public class Solution {
    /**
     * @param S: a string
     * @param K: a integer
     * @return: return a string
     */
    public String licenseKeyFormatting(String S, int K) {
        // write your code here
        int counter=0;
        StringBuilder sb=new StringBuilder();
        for(int i=S.length()-1; i>-1; --i){
            char curr=S.charAt(i);
            if(curr=='-'){
                continue;
            }
            sb.append(Character.toUpperCase(curr));
            ++counter;
            if(counter==K){
                sb.append('-');
                counter=0;
            }
        }
        if(sb.charAt(sb.length()-1)=='-'){
            return sb.reverse().substring(1).toString();
        }
        else{
            return sb.reverse().toString();
        }
    }
}
