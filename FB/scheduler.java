class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char c : tasks){
            ++count[c-'A'];
        }
        
        int max = 0, cnt = 0;
        for(int i=25;i>=0;--i){
            if(count[i] == max){
                ++cnt; //  tailing
            }else if(count[i]>max){
                max = count[i];
                cnt = 1;
            }
        }
        // arrange max-1 intervals, either having idle(not filling all n) or the original length of the array. and adding trailing number; number of block plus tailing
        return Math.max(tasks.length, (max-1)*(n+1) + cnt);
    }
}
