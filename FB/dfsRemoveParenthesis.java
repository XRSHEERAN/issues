class Solution {
    public List<String> removeInvalidParentheses(String s) {
        // for each character chose either keep it or not (DFS), each case like a state node
        dfs(s,0,0,0,0, new StringBuilder());
        return new ArrayList(ret);
    }
    private int globalMin = Integer.MAX_VALUE;
    private HashSet<String> ret = new HashSet<String>();
    private void dfs(String s, int i, int left, int right, int rm, StringBuilder sb){
        // check current position
        if(i == s.length()){
            // done with the whole string
            if(left == right && rm<=globalMin){
                if(rm<globalMin){
                    ret = new HashSet<String>();
                    globalMin = rm;
                }
                ret.add(sb.toString());
            }
        }else{
            ++i; // increment to next
            char curr = s.charAt(i);
            // remove this one
            dfs(s,i,left,right,rm+1,sb);
            // cases of keeping
            sb.append(curr);
            if(curr == '('){
                // we can always include ( and hope it can be matched later
                dfs(s,i,left+1,right,rm,sb);
            }else if(curr == ')' && left>right){
                // we can keep ) if there is unmatched left bracket
                dfs(s,i,left,right+1,rm,sb);
            }else{
                dfs(s,i,left,right,rm,sb);
            }
            sb.setLength(sb.length() - 1); // pop the addition
        }
    }
}
