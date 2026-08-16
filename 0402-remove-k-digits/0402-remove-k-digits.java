class Solution {
    public String removeKdigits(String num, int k) {
        char ch[] = num.toCharArray();
        Stack<Character> st = new Stack<>();

        for(char i : ch)
        {
            while(!st.isEmpty() && k>0 && st.peek() > i)
            {
                st.pop();
                k--;
            }
            st.push(i);
        }

        while(k>0)
        { st.pop(); k--;}

        StringBuilder s = new StringBuilder();
        while (!st.isEmpty())
        s.append(st.pop());

        s.reverse();

        while(s.length() > 1 && s.charAt(0) == '0')
        s.deleteCharAt(0);

        return s.length() == 0 ? "0" : s.toString();
        
    }
}