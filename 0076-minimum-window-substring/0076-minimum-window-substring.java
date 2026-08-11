class Solution {
    public String minWindow(String ss, String tt) {
        int n = ss.length() , m = tt.length();
        int f[] = new int[128];

        char[] t = tt.toCharArray() , s=ss.toCharArray();

        for(char i:t)
        f[i]++;

        int l =0,r=0,start=-1,min = Integer.MAX_VALUE,c = 0;

        while(r<n)
        {
            if(f[s[r]]>0) c++;
            f[s[r]]--;

            while(c == m)
            {
                if(r-l+1 < min)
                {
                    min = r-l+1;
                    start = l;
                }
                f[s[l]]++;
                if(f[s[l]] > 0) c--;
                l++;
            }
            r++;

        }
        return start == -1 ? "" :ss.substring(start , start+min);
        
    }
}