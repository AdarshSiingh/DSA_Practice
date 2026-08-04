class Solution {
    public int numberOfSubstrings(String s) {
        char a[] = s.toCharArray();
        int n = a.length;
        int l = 0 , r = 0 , sum=0;
        int[] f = {0,0,0};

        while(r<n)
        {
            f[a[r]-'a']++;

            while(f[0]>0 && f[1] > 0 && f[2]>0)
            {
                sum+=n-r;

                f[a[l]-'a']--;
                l++;


            }
            r++;


        }
        return sum;
        
    }
}