class Solution {
    public int lengthOfLongestSubstring(String s) {

        char[] c = s.toCharArray();
        int n = c.length;
        int l = 0 , r = 0;
        Set<Character> set = new HashSet<>();
        int len = 1, max = 1;

        while(r<n)
        {
            while(set.contains(c[r]))
            {
                set.remove(c[l]);
                l++;
                len--;
            }

            set.add(c[r]);
            r++;
            len++;

            max = Math.max(max,len);
        }
        
        return max-1;
    }
}