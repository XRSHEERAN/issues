My dp solution
```
class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0 || s.charAt(0) == '0'){
            return 0;
        }
        
        int[] counts = new int[s.length()+1];
        
        counts[0] = 1;
        counts[1] = 1;
        // conduct dp
        for(int i = 1; i<s.length();++i){
            char curr = s.charAt(i);
            if(curr != '0'){
                counts[i+1] = counts[i];
            } 
            if(s.charAt(i-1)!='0'){
                int num = (s.charAt(i-1)-'0')*10 + (curr-'0');
                System.out.println(num);
                if(num < 27){
                    counts[i+1] += counts[i-1];
                }
            }
        }
        return counts[s.length()];
    }
}
```
