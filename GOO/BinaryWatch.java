public class Solution {
    /**
     * @param num: the number of "1"s on a given timetable
     * @return: all possible time
     */
    public List<String> binaryTime(int num) {
        // Write your code here
        int[] min=new int[]{1,2,4,8,16,32};
        //hour
        List<String> ret=new LinkedList<>();
        for(int i=0;i<12;++i){
            String h= ""+i+':';
            int temp=calc(i);
            //minute
            time(h,min,num-temp,ret,0,0);
        }
        return ret;
    }
    private int calc(int num){
        if(num==0){
            return 0;
        }
        int temp=0;
        while(num>0){
            if((num&1)==1){
                ++temp;
            }
            num>>=1;
        }
        return temp;
    }
    private void time(String h, int[] min,int n, List<String> ret,int curr, int strt){
        if(n==0){
            if(curr<10){
                ret.add(new String(h+"0"+curr));
            }
            else{
                ret.add(new String(h+curr));
            }
        }
        if(n<=0){
            return;
        }
        for(int i=strt;i<min.length;++i){
            if(curr+min[i]>=60){
                break;
            }
            time(h,min,n-1,ret,curr+min[i],i+1);
        }
    }
}
