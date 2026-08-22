class Solution {
    public boolean checkDivisibility(int n) {

        int s = 0 , p = 1 , m = n , d = 0;

        while(n>0)
        {
            d = n%10;
            s+=d;
            p*=d;
            n=n/10;
        }

        if(m%(s+p) != 0) return false;

        return true;
        
    }
}