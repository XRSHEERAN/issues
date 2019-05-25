public class Solution {
    /**
     * @param s: an expression includes numbers, letters and brackets
     * @return: a string
     */
    public String expressionExpand(String s) {
        // write your code here
        StringBuilder sb=new StringBuilder();
        int ptr=0;
        Stack<StringBuilder> stk=new Stack<StringBuilder>();
        Stack<Integer> count=new Stack<>();
        
        while(ptr<s.length()){
            char curr=s.charAt(ptr);
            if(Character.isDigit(curr)){
                stk.push(sb);
                int num=0;
                while(Character.isDigit(s.charAt(ptr))){
                    num=num*10+s.charAt(ptr)-'0';
                    ++ptr;
                }
                count.push(num);
                sb=new StringBuilder();
            }
            else if(curr==']'){
                StringBuilder temp=sb;
                sb=stk.pop();
                int num=count.pop();
                for(int i=0;i<num;++i){
                    sb.append(temp);
                }
            }
            else{
                sb.append(curr);
            }
            ++ptr;
        }
        while(!stk.isEmpty()){
            StringBuilder temp=sb;
            sb=stk.pop();
            for(int i=1;i<count.pop();++i){
                sb.append(temp);
            }
        }
        return sb.toString();
    }
}
