class P
{
    String s ; int n;
    P(String ss , int nn)
    { s=ss; n = nn;}
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> words) {
        Queue<P> q = new LinkedList<>();
        Set<String> st = new HashSet<>();

        for(String i : words)
        st.add(i);

        q.add(new P(beginWord,1));
        st.remove(beginWord);

        while(!q.isEmpty())
        {
            P p = q.remove();
            String s = p.s;
            int n = p.n;

            if(s.equals(endWord)) return n;

            for(int i = 0 ;i<s.length();i++)
            for(char ch = 'a' ; ch <= 'z'; ch++)
            {
                char[] arr = s.toCharArray();
                arr[i] = ch;
                String sr = new String(arr);

                if(st.contains(sr))
                {
                    q.add(new P(sr,n+1));
                    st.remove(sr);
                }
                 
            }
        }
        return 0;
        
    }
}