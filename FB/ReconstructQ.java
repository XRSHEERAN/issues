public class Solution {
    /**
     * @param people: a random list of people
     * @return: the queue that be reconstructed
     */
    public int[][] reconstructQueue(int[][] people) {
        // write your code here
        if(people.length==0){
            return new int[0][0];
        }
        Arrays.sort(people, new Comparator<int[]>(){
                public int compare(int[] a, int[] b){
                    int rst=b[0]-a[0];
                    if(rst==0){
                        rst=a[1]-b[1];
                    }
                    return rst;
                }
            }
        );
        List<int[]> lst=new LinkedList<>();
        lst.add(people[0]);
        for(int i=1;i<people.length;++i){
            lst.add(people[i][1],people[i]);
        }
        for(int i=0;i<people.length;++i){
            people[i]=lst.get(i);
        }
        return people;
    }
}
