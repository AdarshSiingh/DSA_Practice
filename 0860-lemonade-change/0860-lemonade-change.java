class Solution {
    public boolean lemonadeChange(int[] b) {
        int n = b.length;
        int f =0,t=0;

        for(int i:b)
        {
            if(i == 5) f++;
            else if(i == 10)
            {
                if(f>0){ f--; t++;}
                else  return false;
            }
            else
            {
                if(f>0 && t>0) {f--;t--;}
                else if(f>=3){f-=3;}
                else return false;
            }
        }

        return true;
        
    }
}