class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1=version1.split("\\."),v2=version2.split("\\.");
        int ptr=0;
        while(ptr<v1.length && ptr<v2.length){
            int a=Integer.parseInt(v1[ptr]),b=Integer.parseInt(v2[ptr]);
            
            if(a<b){
                return -1;
            }
            else if(a>b){
                return 1;
            }
            ++ptr;
        }
        while(ptr<v1.length){
            if(Integer.parseInt(v1[ptr])>0){
                return 1;
            }
            ++ptr;
        }
        while(ptr<v2.length){
            if(Integer.parseInt(v2[ptr])>0){
                return -1;
            }
            ++ptr;
        }
        return 0;
    }
}
