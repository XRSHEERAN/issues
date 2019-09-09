class Solution {
    public boolean validPalindrome(String s) {
        int l=0,r=s.length()-1;
        while(l<r){
            if(s.charAt(l)==s.charAt(r)){
                ++l;
                --r;
                continue;
            }
            else{
                return validator(s,l+1,r) || validator(s,l,r-1);
            }
            
        }
        return true;
    }
    private boolean validator(String s, int l, int r){
        while(l<r){
            if(s.charAt(l)==s.charAt(r)){
                ++l;
                --r;
                continue;
            }
            else{
                return false;
            }
            
        }
        return true;
    }
}

