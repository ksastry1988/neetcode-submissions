class Solution {
    public int evalRPN(String[] tokens) {
        List<String> list = new ArrayList<>(List.of("+", "-", "*", "/"));

        Stack<String> stack = new Stack<>();

        for(String token: tokens){
            if(list.contains(token)){
                int first = Integer.parseInt(stack.pop());
                int second = Integer.parseInt(stack.pop());

                int result =  0;

                if(token.equals("+")){
                    result = first + second;
                }
                else if(token.equals("-")){
                    result = second - first;
                }
                else if(token.equals("*")){
                    result = second * first;
                }
                else if(token.equals("/")){
                    result = second / first;
                }
                stack.push(String.valueOf(result));
            }
            else{
                stack.push(token);
            }
        }

        return Integer.parseInt(stack.pop());
    }
}
