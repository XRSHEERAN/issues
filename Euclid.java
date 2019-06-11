public int gcd(int a, int b){
  whlie(b!=0){
    int temp=a;
    a=b;
    b=temp%b;
  }//returns gcd in O(a+b) time
  return a;
}
