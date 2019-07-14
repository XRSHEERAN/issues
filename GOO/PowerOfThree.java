public class Solution {
    /**
     * @param n: an integer
     * @return: if n is a power of three
     */
    public boolean isPowerOfThree(int n) {
        if(n==1){
            return true;
        }
        // Write your code here
        while(n!=0){
            int temp=n%3;
            if(temp==0){
                n/=3;
                if(n==1){
                  return true;
                }
            }
            else{
                return false;
            }
        }
        return false;
    }
}
