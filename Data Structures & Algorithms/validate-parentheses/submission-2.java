class Solution {
    public boolean isValid(String s) {
        
        if (s.length() % 2 == 1){
            return false;
        }
        else{
            Stack<Character> myStack = new Stack<>();
            java.util.Map<Character, Character> closeToOpen = new java.util.HashMap<>();
        
            closeToOpen.put(')', '(');
            closeToOpen.put(']', '[');
            closeToOpen.put('}', '{');

            for(char c : s.toCharArray()){
                if(closeToOpen.containsKey(c)){
                    if(!myStack.isEmpty() && myStack.peek() == closeToOpen.get(c))
                        myStack.pop();
                    else
                        return false;
                }
                else{
                    myStack.push(c);
                }
            }

            return myStack.isEmpty();
        }
    }
}

