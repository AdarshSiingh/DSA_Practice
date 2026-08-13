class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        Map<Integer,Integer> m = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        int res[] = new int[nums1.length];
      
        for(int i = nums2.length -1 ; i>=0 ;i--)
        {
            while(!st.isEmpty() && nums2[i] > st.peek())
            st.pop();

            int ans = st.isEmpty() ? -1 : st.peek();

            m.put(nums2[i],ans);
            st.push(nums2[i]);
        }

       for(int i=0;i<nums1.length;i++)
       res[i] = m.get(nums1[i]);

       return res;





        
    }
}