import java.util.Stack;

class MinStack {

    // 각 메서드는 O(1)의 시간 복잡도를 가져야 한다.

    private Stack<Integer> stack;
    private int min; // getMin() 호출 시 반환해야 할 stcak의 최소값 기록

    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE; // 일단 정수 최대값으로 초기화
    }
    
    public void push(int val) {
        // 만약, val이 min보다 작거나 같다면(최소값 갱신해야 하는 상황)
        if (val <= min) {
            // stack에 min 추가 및 min을 val로 갱신
            stack.push(min);
            min = val;
        }
        // stack에 val 추가
        stack.push(val);
    }
    
    public void pop() {
        // pop하려는 값이 최소값과 같다면 MinStack의 min 갱신 필요
        if (stack.pop() == min) {
            // 한번 더 pop해서 min 갱신
            min = stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */