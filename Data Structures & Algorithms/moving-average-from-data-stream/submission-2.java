class MovingAverage {

    public int size;
    public Queue<Integer> queue;

    public MovingAverage(int size) {

        this.size = size;
        this.queue = new LinkedList<>();
        
    }
    
    public double next(int val) {

        int total = 0;

        queue.add(val);

        if(queue.size() > size)
            queue.poll();

        for(int item : queue)
            total += item;

        return (double) total / queue.size();
        
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
