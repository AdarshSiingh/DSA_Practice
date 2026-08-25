class Solution {
    public int maxArea(int[] h) {

        int n = h.length , l = 0 , r = n-1 , a=0;

        while(l<r)
        {
            a = Math.max(a,((r-l) * (Math.min(h[l],h[r]))));
            if(h[l]<h[r]) l++;
            else r--;
        }

        return a;

        
    }
}