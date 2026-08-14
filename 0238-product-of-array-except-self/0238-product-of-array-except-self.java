class Solution {
    public int[] productExceptSelf(int[] a) {
        int n = a.length;
        int ans[] = new int[n];

        int l = 1,r=1;
        for(int i = 0;i<n;i++)
        {
            ans[i] = l;
            l*=a[i];
        }

        for(int i = n-1;i>=0;i--)
        {
            ans[i]*=r;
            r*=a[i];

        }

        return ans;
        
    }
}