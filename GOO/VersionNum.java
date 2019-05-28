public class Solution {
    /**
     * @param version1: the first given number
     * @param version2: the second given number
     * @return: the result of comparing
     */
    public int compareVersion(String version1, String version2) {
        // Write your code here
        int v1=0,v2=0;
        while(v1<version1.length() || v2<version2.length()){
            int num1=0,num2=0;
            if(v1>=version1.length()){
                num1=0;
            }
            else if(v2>=version2.length()){
                num2=0;
            }
            while(v1<version1.length() && version1.charAt(v1)!='.'){
                    num1=num1*10+version1.charAt(v1++)-'0';
            }
            while(v2<version2.length() && version2.charAt(v2)!='.'){
                    num2=num2*10+version2.charAt(v2++)-'0';
            }
            
            if(num1!=num2){
                return (num1-num2)/Math.abs(num1-num2);
            }
            ++v1;
            ++v2;
        }
        return 0;
    }
}
