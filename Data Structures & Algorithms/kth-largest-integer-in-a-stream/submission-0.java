class KthLargest {

    Queue<Integer> heap;
    int k;

    public KthLargest(int k, int[] nums) {

        this.heap = new PriorityQueue<>();
        this.k = k;

        for(int num : nums){
            heap.add(num);
            if (heap.size() > k)
                heap.poll();
        }       
        
    }
    
    public int add(int val) {
        this.heap.add(val);
        if (heap.size() > k)
                heap.poll();
        return heap.peek();
    }
}
