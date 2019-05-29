public class Solution {
    /**
     * @param temperatures: a list of daily temperatures
     * @return: a list of how many days you would have to wait until a warmer temperature
     */
    public int[] dailyTemperatures(int[] temperatures) {
        // Write your code here
        Stack<Integer> stk=new Stack<>();//track of large numbers
        int[] ret=new int[temperatures.length];
        
        for(int i=temperatures.length-1;i>=0;--i){
            while(!stk.isEmpty() && temperatures[stk.peek()]<=temperatures[i]){
                stk.pop();
            }
            ret[i]=(stk.isEmpty())?0:stk.peek()-i;
            stk.push(i);
        }
        return ret;
    }
}
