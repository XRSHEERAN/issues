class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights.length==0)
            return 0;
        int max=findMax(heights,0);
        for(int i=1;i<heights.length;i++){
            if(i>0 && heights[i]==heights[i-1])
                continue;
            max=Math.max(max,findMax(heights,i));
        }
        return max;
    }
    public int findMax(int[] heights, int curr){
        int lft=curr-1,rgt=curr+1;
        boolean l=true,r=true;
        while((lft>=0 || rgt<heights.length) && ( l || r)){
            l=false;
            r=false;
            if(lft>=0 && heights[lft]>=heights[curr]){
                lft--;
                l=true;
            }
            if(rgt<heights.length && heights[rgt]>=heights[curr]){
                rgt++;
                r=true;
            }
        }
        return (rgt-lft-1)*heights[curr];
    }
}
