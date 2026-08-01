class Solution {
    public int longestOnes(int[] a, int k) {

        int n = a.length, l = 0 , r = 0 , max = 0 , z = 0;

        while(r<n)
        {
            if(a[r]==0)
            z++;
            while(z>k)
            {
                if(a[l]==0) z--;
                
                l++;
            }

            max = Math.max(max,r-l+1);
            r++;
        }
        return max;
        
        
    }
}