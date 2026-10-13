class MinStack {
    Stack <Integer> main;
    Stack<Integer> min;
    public MinStack() {
        main = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        main.push(val);
        if(!min.isEmpty()){
            if(val <= min.peek()){
                min.push(val);
            }
        }else{
            min.push(val);
        }
    }
    
    public void pop() {
        int last=main.pop();
        if(!min.isEmpty() && min.peek()==last){
            min.pop();
        }

    }
    
    public int top() {
        return main.peek();
    }
    
    public int getMin() {
        return min.peek();
        
    }
}
