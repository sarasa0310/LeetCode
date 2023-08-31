class Solution {
    public int evalRPN(String[] tokens) {
        // 1. Stack 자료구조 활용
        Stack<Integer> stack = new Stack<>();

        // 2. tokens 배열 전체 순회하면서 stack에 연산 결과 업데이트
        for (String token : tokens) {
            // 2-1. token이 "+"일 때
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            }
            // 2-2. token이 "-"일 때
            else if (token.equals("-")) {
                stack.push(-(stack.pop() - stack.pop()));
            }
            // 2-3. token이 "*"일 때
            else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            }
            // 2-4. token이 "/"일 때
            else if (token.equals("/")) {
                int first = stack.pop();
                int second = stack.pop();
                stack.push(second / first);
            }
            // 2-5. token이 단순 숫자일 때
            else {
                stack.push(Integer.valueOf(token));
            }
        }

        // 3. stack에 저장된 마지막 결과 값 리턴
        return stack.pop();
    }

    // public static boolean isNumeric(String token) {
    //     try {
    //         int d = Integer.parseInt(token);
    //     } catch (NumberFormatException e) {
    //         return false;
    //     }
    //     return true;
    // }

}