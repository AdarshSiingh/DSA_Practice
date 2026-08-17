class Solution {
    public int jump(int[] n) {
        int l=0,r=0,j=0;

        while(r< n.length-1)
        {
            int far = 0;
            for(int i =l;i<=r;i++)
            {
                far = Math.max(far,i+n[i]);
            }
            l=r+1;
            r=far;
            j++;

        }

        return j;
        
    }
}