class Solution {
    public int numSubarraysWithSum(int[] a, int k) {

        int n = a.length,cs=0,res=0;
        Map<Integer,Integer> m = new HashMap<>();
        m.put(0,1);

        for(int i = 0 ; i <n;i++)  
        {
            cs+=a[i];

            res+=m.getOrDefault(cs-k,0);
            m.put(cs,m.getOrDefault(cs,0)+1);
        }   
        return res;   
    }
}