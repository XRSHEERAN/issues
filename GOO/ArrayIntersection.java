public class Solution {
    /**
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length==0 || nums2.length==0){
            return new int[0];
        }
        // write your code here
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1=0,p2=0;
        List<Integer> lst=new LinkedList<Integer>();
        while(p1<nums1.length && p2<nums2.length){
            if(nums1[p1]==nums2[p2]){
                lst.add(nums1[p1]);
                ++p1;
                ++p2;
            }
            else if(nums1[p1]<nums2[p2]){
                ++p1;
            }
            else{
                ++p2;
            }
        }
        int[] ret=new int[lst.size()];
        int ptr=0;
        for(int i:lst){
            ret[ptr++]=i;
        }
        return ret;
    }
}
