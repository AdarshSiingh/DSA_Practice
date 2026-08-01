class Solution {
    public int lengthOfLongestSubstring(String s) {

        if(s.length()==0) return 0;

        char[] c = s.toCharArray();
        int n = c.length;
        int l = 0 , r = 0;
        Set<Character> set = new HashSet<>();
        int  max = 1;

        while (r < n) {
    while (set.contains(c[r])) {
        set.remove(c[l]);
        l++;
    }

    set.add(c[r]);
    max = Math.max(max, r - l + 1);
    r++;
}
        
        return max;
    }
}