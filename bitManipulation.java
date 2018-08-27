//Xor doesn't require order a^b^c==a^c^b
    public int solution(int[] A) {
        // write your code in Java SE 8
        int ret=A[0];
        for(int i=1;i<A.length;i++){
            ret^=A[i];
        }
        return ret;
    }
