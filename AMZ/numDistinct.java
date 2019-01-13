int numDistinct(string s, string t) {
        if(s.size()==0)
            return 0;
        if(t.size()==0)
            return 1;
        
        int dp[s.size()+1][t.size()+1]{};
        for(int i=0;i<s.size();++i){
            dp[i][0]=1;
        }
        for(int i=0;i<s.size();++i){
            for(int j=0;j<t.size();++j){
                dp[i+1][j+1]=dp[i][j+1];
                if(s[i]==t[j]){
                    dp[i+1][j+1]+=dp[i][j];
                }
            }
        }
        return dp[s.size()][t.size()];
    }