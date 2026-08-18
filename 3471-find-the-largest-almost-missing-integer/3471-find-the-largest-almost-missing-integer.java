class Solution {
    public int largestInteger(int[] a, int k) {
        int n = a.length;

        Map<Integer, Integer> m = new HashMap<>();

        for (int x : a)
        m.put(x, m.getOrDefault(x, 0) + 1);
        int ans = -1;

        if(k == 1)
        {
            for(int i:a)
            {
                if(m.get(i) == 1)
                ans = Math.max(ans,i);
            }
        
        }
        else if(k == n)
        {
            for(int i:a)               
            ans = Math.max(ans,i);
        }
        else
        {
            if(m.get(a[0]) == 1)
            ans = Math.max(ans,a[0]);

            if(m.get(a[n-1]) == 1)
            ans = Math.max(ans,a[n-1]);
        }

        return ans;

        
       
        
    }
}