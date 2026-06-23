class MinStack {
    Deque<Integer> st;
    Deque<Integer> min;

    public MinStack() {
        st = new ArrayDeque<>();
        min = new ArrayDeque<>();
        min.addLast(Integer.MAX_VALUE);
    }

    public void push(int value) {
        st.addLast(value);
        if(min.isEmpty())
            min.addLast(value);
        else
            min.addLast(Math.min(value, min.peekLast()));
    }

    public void pop() {
        st.removeLast();
        min.removeLast();
    }

    public int top() {
        return st.peekLast();
    }

    public int getMin() {
        return min.peekLast();
    }
}