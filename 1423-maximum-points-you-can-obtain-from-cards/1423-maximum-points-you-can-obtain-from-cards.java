class Solution {
    public int maxScore(int[] a, int k) {

        int  n = a.length , l=k-1,r=n-1,sum =0, ls =0 , rs =0 ;
        for(int i =0;i<k;i++)
        ls+=a[i];
        int max = ls;

        while(l>=0)
        {
            ls-=a[l];
            l--;
            rs+=a[r];
            r--;

            max = Math.max(max,ls+rs);
        }
        return max;
        
    }
}