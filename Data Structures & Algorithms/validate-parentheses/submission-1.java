class Solution {
    public boolean isValid(String s) {
        if(s.length() == 0) return true;

        char[] chars = s.toCharArray();

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for(char c: chars){
            if(!stack.isEmpty() && (c == ')' || c == ']' || c == '}')){
                if(stack.peek() == map.get(c)){
                    stack.pop();
                }
                else{
                    return false;
                }
        }
        else {
            stack.push(c);
        }
    }

    return stack.isEmpty(); 
}
}
