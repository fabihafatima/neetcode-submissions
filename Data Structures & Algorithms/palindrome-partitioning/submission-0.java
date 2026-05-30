class Solution {
    public List<List<String>> partition(String s) {
        List<String> cur = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        palindromePartition(0, s, cur, res);
        return res;

    }
    void palindromePartition(int index, String st, List<String> ans, List<List<String>> res ){
        if(index==st.length()){
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int i = index; i < st.length(); i++) {
            if (isValidPalindrome(index, i, st)) {
                ans.add(st.substring(index, i + 1));
                palindromePartition(i + 1, st, ans, res);
                ans.remove(ans.size() - 1);
            }
        }
    }
    boolean isValidPalindrome(int left, int right, String st){
        while(left<=right){
            if(st.charAt(left)!=st.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

