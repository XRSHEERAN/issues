//Intuitive Method
class Fabonacci{
  public long First(int a, int b, int n){
    int my1, my2, my3;
    my1=a%1000000007;
    my2=b%1000000007;
    for (int i=0;i<n+1;i++){
      my3=my1+my2;
      my1=my2;
      my2=my3;
      }
     return my3;
   }
}
Time complexity is N, space is 1


//More sophisticated method
