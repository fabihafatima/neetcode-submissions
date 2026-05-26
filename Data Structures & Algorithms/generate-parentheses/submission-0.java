class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        permutations(n,0,0, new StringBuilder(), res );
        return res;
    }
    void permutations(int n, int open, int close,  StringBuilder parenString, List<String>res){
        if(open == close && close == n){
            res.add(parenString.toString());
            return;
        }
        if(open<n){
            parenString.append("(");
            permutations(n, open+1, close, parenString, res);
            parenString.deleteCharAt(parenString.length() - 1);

        }
        if(close<open){
            parenString.append(")");
            permutations(n, open, close+1, parenString, res);
            parenString.deleteCharAt(parenString.length() - 1);

        }

    }
}
