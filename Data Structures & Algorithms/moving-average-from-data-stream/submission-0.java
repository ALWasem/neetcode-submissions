class MovingAverage {

    int size;
    Queue<Integer> queue;

    public MovingAverage(int size) {

        this.size = size;
        this.queue = new LinkedList<>();
        
    }
    
    public double next(int val) {

        double total = 0;

        queue.offer(val);

        if(queue.size() > this.size)
            queue.poll();

        for(Integer value : queue)
            total += value;

        return total / queue.size();
        
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
