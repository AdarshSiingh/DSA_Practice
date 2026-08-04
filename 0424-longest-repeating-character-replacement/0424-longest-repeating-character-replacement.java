class Solution {
    public int characterReplacement(String s, int k) {
        char[] a = s.toCharArray();
        int n = a.length;
        int r =0,l=0,m=0,max=0;
        int[] f = new int[26];

        while(r<n)
        {
            f[a[r]-'A']++;
            m = Math.max(m,f[a[r]-'A']);

            while((r-l+1)-m > k)
            {
                f[a[l]-'A']--;
                l++;
            }

            max = Math.max(max,r-l+1);
            r++;

        }
        return max;
        
    }
}