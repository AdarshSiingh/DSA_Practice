class Solution {
    public List<Integer> findMissingElements(int[] a) {

        Arrays.sort(a);
        int n = a.length;
        int s = a[0] , e = a[n-1],k=0;
        List<Integer> l = new ArrayList<>();
        
        for(int i = s ; i<=e;i++)
        {
            if(a[k]!=i)
            {l.add(i); continue;}
            k++;

        }
        return l;
        
    }
}