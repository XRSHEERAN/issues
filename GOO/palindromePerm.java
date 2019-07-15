public class Solution {
    /**
     * @param s: the given string
     * @return: if a permutation of the string could form a palindrome
     */
    public boolean canPermutePalindrome(String s) {
        // write your code here
        int[] chars=new int[26];
        int left=0;
        for(int i=0;i<s.length();++i){
            int temp=s.charAt(i)-'a';
            if(chars[temp]==1){
                chars[temp]=0;
                --left;
            }
            else{
                chars[temp]=1;
                ++left;
            }
        }
        return left<2;
    }
}
