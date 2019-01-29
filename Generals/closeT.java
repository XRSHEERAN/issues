public class Solution {
    /**
     * @param time: the given time
     * @return: the next closest time
     */
    public String nextClosestTime(String time) {
        // write your code here
        //get current minutes and hours
        int hrs=Integer.parseInt(time.substring(0,2)), mnt=Integer.parseInt(time.substring(3));
        List<Integer> tbl=new ArrayList<Integer>(4);
        for(int i=0;i<time.length();++i){
            if(time.charAt(i)==':'){
                continue;
            }
            int temp=time.charAt(i)-'0';
            if(!tbl.contains(temp)){
                tbl.add(temp);
            }
        }
        int clsH=-1,clsM=-1,minH=hrs,minM=mnt;
        
        for(int i=0;i<tbl.size();++i){
            int temp=tbl.get(i);
            if(temp>5){
                continue;
            }
            temp*=10;
            
            for(int j=0;j<tbl.size();++j){
                temp+=tbl.get(j);
                //minutes, clothest (larger) to current mnt
                if(temp>mnt && (clsM==-1 || clsM>temp) ){
                    clsM=temp;
                }
                //smallest minutes possible
                if(minM>temp){
                    minM=temp;
                }
                
                if(temp<24){
                    //hours that is strictly larger than hrs
                    if(temp>hrs && (clsH==-1 || clsH>temp) ){
                        clsH=temp;
                    }
                    //smallest possible hours
                    if(minH>temp){
                        minH=temp;
                    }
                }
                temp-=tbl.get(j);
            }
        }
        String retH,retM;
        if(clsM>0){
            retH=(hrs<10)?"0"+hrs:""+hrs;
            retM=(clsM<10)?"0"+clsM : ""+clsM;
            
        }
        else if(clsH>0){
            retH=(clsH<10)?"0"+clsH:""+clsH;
            retM=(minM<10)?"0"+minM : ""+minM;
        }
        else{
            retH=(minH<10)?"0"+minH:""+minH;
            retM=(minM<10)?"0"+minM : ""+minM;
        }
        return retH+":"+retM;
    }
}
