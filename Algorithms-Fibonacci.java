/* Author: Xianrun QU*/

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

//Time complexity is N, space is 1


//More sophisticated method
/*
f n is even then k = n/2:
F(n) = [2*F(k-1) + F(k)]*F(k)

If n is odd then k = (n + 1)/2
F(n) = F(k)*F(k) + F(k-1)*F(k-1)

This is noted by geeks for geeks
can be pretty useful
*/
  //here is the recursive helper,we assume F(0)=a and F(1)=b
 public long Second(int a, int b, int n){
   if(n==0)
     return a;
   if(n==1)
     return b;
   //condition 1
   if(n%2==0)
     return [2*Second(a,b,n/2-1)+Second(a,b,n/2)]*Second(a,b,n/2);
   return Second(a,b,(n+1)/2)*Second(a,b,(n+1)/2)+Second(a,b,(n-1)/2)*Second(a,b,(n-1)/2);
 }
}
