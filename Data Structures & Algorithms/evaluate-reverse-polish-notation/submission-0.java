class Solution {
    public int evalRPN(String[] tokens) {
        Stack <Integer> stack = new Stack<>();
        for(int i =0; i< tokens.length; i++){
            String val = tokens[i];
            if(val.equals("+")){
                if(stack.size()>=2){
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(a+b);
                }
            }
            else if(val.equals("-")){
                if(stack.size()>=2){
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b-a);
                }
            }
            else if(val.equals("*")){
                if(stack.size()>=2){
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b*a);
                }
            }
            else if(val.equals("/")){
                if(stack.size()>=2){
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b/a);
                }
            }
            else{
                stack.push(Integer.parseInt(val));
            }
        }
        return stack.pop();
    }
}
