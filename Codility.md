## Missing Number
```JAVA
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
import java.util.*;
class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        
        int N=A.length, ret=0;
        for(int i : A){
            if(i%2==0)
                ret+=i;
            else
                ret-=i;
        }
        int pos=N/2;
        if(N%2==1){
            pos-=N;
            ret-=(N+1);
        }
        else
            ret+=(N+1);
        return Math.abs(ret-pos);
    }
}
```
