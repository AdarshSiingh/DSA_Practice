class Solution {
    public int totalFruit(int[] a) {

        int n = a.length;
        Map<Integer,Integer> m = new HashMap<>();

        int l = 0 , r =0 , max = 1 ;

        while(r<n)
        {
            m.put(a[r],m.getOrDefault(a[r],0)+1);
            if(m.size()>2)
            {
                while(m.size()>2)
                {
                    m.put(a[l],m.get(a[l])-1);
                    if(m.get(a[l]) == 0) m.remove(a[l]);
                    l++;
                }
            }
            max = Math.max(max,r-l+1);
            r++;
        }
        return max;

        
    }
}