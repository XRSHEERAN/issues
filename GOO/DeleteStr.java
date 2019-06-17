public class Solution {
    /**
     * @param word1: a string
     * @param word2: a string
     * @return: return a integer
     */
    public int minDistance(String word1, String word2) {
        // write your code here
        
        int[][] maxSub=new int[word1.length()+1][word2.length()+1];
        for(int i=1;i<=word1.length();++i){
            for(int j=1;j<=word2.length();++j){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    maxSub[i][j]=maxSub[i-1][j-1]+1;
                }
                else{
                    maxSub[i][j]=Math.max(maxSub[i-1][j],maxSub[i][j-1]);
                }
            }
        }
        int ret=word1.length()+word2.length()-maxSub[word1.length()][word2.length()]*2;
        return ret;
    }
}
