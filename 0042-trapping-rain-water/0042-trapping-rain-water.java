class Solution {
    public int trap(int[] h) {
        int n = h.length , t =0;
        int[] l = new int[n] , r = new int[n];

        l[0] = h[0];
        r[n-1] = h[n-1];

        for(int i =1;i<n;i++)
        l[i] = Math.max(l[i-1],h[i]);

        for(int i=n-2;i>=0;i--)
        r[i]=Math.max(r[i+1],h[i]);

        for(int i =0;i<n;i++)
        t += Math.min(l[i],r[i]) - h[i];

        return t;
    }
}