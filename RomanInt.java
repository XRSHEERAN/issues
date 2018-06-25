//Roman to int
class Solution {
    /*Symbol         Value
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000*/
    public int romanToInt(String s) {
        if(s==null)
            return 0;
        int num=0;
        char[] chars=s.toCharArray();
        for(int i=0;i<chars.length;i++){
            char c=chars[i];
            if(c=='M'){
                num+=1000;
            }
            else if(c=='V'){
                num+=5;
            }
            else if(c=='L'){
                num+=50;
            }
            else if(c=='D'){
                num+=500;
            }
            else if(c=='M'){
                num+=1000;
            }
            else if(c=='I'){
                if(i+1<s.length() && (s.charAt(i+1)=='V' || s.charAt(i+1)=='X')){
                    num+=(s.charAt(i+1)=='X')? 9:4;
                    i++;
                }
                else{
                    num+=1;
                }
            }
            else if(c=='X'){
                if(i+1<s.length() && (s.charAt(i+1)=='L' || s.charAt(i+1)=='C')){
                    num+=(s.charAt(i+1)=='C')? 90:40;
                    i++;
                }
                else{
                    num+=10;
                }
            }
            else if(c=='C'){
                if(i+1<s.length() && (s.charAt(i+1)=='D' || s.charAt(i+1)=='M')){
                    num+=(s.charAt(i+1)=='M')? 900:400;
                    i++;
                }
                else{
                    num+=100;
                }
            }
        }
        return num;
    }
}

//int to roman, here I go with python
