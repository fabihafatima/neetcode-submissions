class Solution {
    public int lengthOfLongestSubstring(String s) {
      HashMap <Character, Integer> seen = new HashMap <>();
      if (s.length()==0) return 0;
      seen.put(s.charAt(0), 0);
      int left =0, right =1;
      int subLen=1, maxSub =1;
      while(right<s.length()){
        if(seen.containsKey(s.charAt(right))){
          left= Math.max(seen.get(s.charAt(right))+1,left); 
        }
        seen.put(s.charAt(right), right);
        subLen=right-left+1;
        maxSub = Math.max(maxSub, subLen);
        right++;

      }
      return maxSub;
    }
}
