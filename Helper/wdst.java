public class HelloWorld{

    private static void wsort(int[] A, int st, int ed){
        int n=ed-st+1;
        if(n>1){
            wsort(A,st,st+n/2-1);
            wsort(A,st+n/2,ed);
            strt(A,st,ed);
        }
    }
    private static void strt(int[] A, int st, int ed){
        int n=ed-st+1;
        if(n==2){
            if(A[ed]<A[st]) swap(A,st,ed);
        }
        else{
            for(int i=st;i<st+n/4;i++){
                swap(A,i+n/4,i+n/2);
            }
            strt(A,st,st+n/2-1);
            strt(A,st+n/2,ed);
            strt(A,st+n/4,st+3*n/4-1);
        }
    }
    private static void swap(int[] A, int i, int j){
        int temp=A[i];
        A[i]=A[j];
        A[j]=temp;
    }
    
    public static void main(String []args){
        int[] arr=new int[]{2,1,4,3};
        wsort(arr,0,arr.length-1);
        System.out.println("Hello World"+arr[0]+arr[1]+arr[2]+arr[3]);
    }
}
