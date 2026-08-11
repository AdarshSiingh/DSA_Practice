class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return f(nums,k) - f(nums,k-1);
        
    }
    int f(int[] a , int k)
    {
        Map<Integer,Integer> m = new HashMap<>();
        int n = a.length;
        int l =0,r=0,ans=0;

        while(r<n)
        {
            m.put(a[r],m.getOrDefault(a[r],0)+1);

            while(m.size() > k)
            {
                m.put(a[l],m.getOrDefault(a[l],0)-1);
                if(m.get(a[l]) == 0) m.remove(a[l]);
                l++;
            }
            ans+=(r-l+1);
            r++;
        }
        return ans;
    }
}