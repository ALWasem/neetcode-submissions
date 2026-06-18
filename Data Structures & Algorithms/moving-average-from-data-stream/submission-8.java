class MovingAverage {

    int size;
    Queue<Integer> queue;

    public MovingAverage(int size) {

        this.size = size;
        this.queue = new LinkedList<>();

    }
    
    public double next(int val) {

        queue.offer(val);

        if(queue.size() > this.size)
            queue.poll();

        int total = 0;

        for(Integer num : queue){
            total += num;
        }

        return (double) total / queue.size();
        
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
