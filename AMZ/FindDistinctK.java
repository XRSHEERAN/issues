public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int lft=0,rgt=arr.length,ptr=(lft+rgt)/2,temp=k;
        while(lft<rgt){
            if(arr[ptr]==x){
                break;
            }
            else if(arr[ptr]<x){
                if(ptr==rgt)
                    break;
                lft=ptr+1;
            }
            else{
                if(ptr==lft)
                    break;
                rgt=ptr-1;
            }
            ptr=(lft+rgt)/2;
        }
        
        if(arr[ptr]==x){
            lft=ptr-1;
            rgt=ptr+1;
            --temp;
        }
        else if(arr[ptr]<x){
            lft=ptr;
            rgt=ptr+1;
        }
        else{
            lft=ptr-1;
            rgt=ptr;
        }
        
        while(temp>0){
            int a=(lft>=0)?x-arr[lft]:-1,b=(rgt<arr.length)?arr[rgt]-x:-1;
            
            if(a==-1){
                ++rgt;
            }
            else if(b==-1){
                --lft;
            }
            else if(a>b){
                ++rgt;
            }
            else{
                --lft;
            }
            --temp;
        }
        
        List<Integer> ret=new ArrayList<Integer>();
        ++lft;
        while(lft<rgt){
            ret.add(arr[lft]);
            ++lft;
        }
        return ret;
    }