class MinStack {
    private Stack<Integer> min = new Stack<Integer>();
    private Stack<Integer> elements = new Stack<Integer>();

    public void push(int x) {
        elements.push(x);
        if (min.isEmpty() || x <= min.peek()) min.push(x);
    }

    public void pop() {
        int e = elements.pop();
        if (e <= min.peek()) min.pop();
    }

    public int top() {
        return elements.peek();
    }

    public int getMin() {
        return min.peek();
    }
}

