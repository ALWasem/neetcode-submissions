class MinStack {

    List<Integer> myStack;

    //int minVal = Integer.MAX_VALUE;

    public MinStack() {

        this.myStack = new ArrayList<>();
        
    }
    
    public void push(int val) {
        myStack.add(val);

        // if(val < minVal)
        //     minVal = val;
    }
    
    public void pop() {
        myStack.remove(myStack.size() - 1);
    }
    
    public int top() {
        return myStack.get(myStack.size() - 1);
    }
    
    public int getMin() {

        int minVal = Integer.MAX_VALUE;

        for(int i : this.myStack){
            if(i < minVal)
                minVal = i;
        }

        return minVal;
        
    }
}
