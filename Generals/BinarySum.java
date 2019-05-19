public int add(int a, int b){
  //adding to number is doing their xor and move the ind forward
  
  while(b!=0){
    int num=a&b;
    a=a^b;
    b=num<<1;
  }
  return a;  
}
