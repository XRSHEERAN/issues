public class Solution {
    /**
     * @param str: the given string
     * @return: the maximum value
     */
    public int calcMaxValue(String str) {
        // write your code here
        if(str.length()==0){
            return 0;
        }
        int[] dp = new int[str.length()];
        dp[0] = str.charAt(0)-'0';
        for(int i=1;i<str.length();++i){
            int curr=str.charAt(i)-'0';
            dp[i]=Math.max(dp[i-1]*curr, dp[i-1]+curr);
        }
        return dp[str.length()-1];
    }
}
