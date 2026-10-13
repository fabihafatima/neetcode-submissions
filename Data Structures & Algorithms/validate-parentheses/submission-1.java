class Solution {
    public boolean isValid(String s) {
        Map <Character, Character>brackets = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        if(s.length()==0) return false;
        brackets.put(')', '(');
        brackets.put(']', '[');
        brackets.put('}', '{');
        // stack.push(s.charAt(0));
        for(int i =0; i<s.length(); i++){
            char curr = s.charAt(i);
            if(curr == '(' || curr=='[' || curr=='{'){
                stack.push(s.charAt(i));
            }
            else{
                if(stack.isEmpty()) return false;
                char open=stack.pop();
                if(open != brackets.get(curr)){
                    return false;
                }
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}
