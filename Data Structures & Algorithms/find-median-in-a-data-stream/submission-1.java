class MedianFinder {

    private Queue<Integer> smallHeap;
    private Queue<Integer> largeHeap;

    public MedianFinder() {

        this.smallHeap = new PriorityQueue<>((a, b) -> b - a);
        this.largeHeap = new PriorityQueue<>((a, b) -> a - b);
        
    }
    
    public void addNum(int num) {

        this.smallHeap.add(num);
        this.largeHeap.add(this.smallHeap.poll());

        if(this.largeHeap.size() > this.smallHeap.size()){
            this.smallHeap.add(this.largeHeap.poll());
        }
        
    }
    
    public double findMedian() {

        if (smallHeap.size() > largeHeap.size())
            return smallHeap.peek();
        else
            return (double) (smallHeap.peek() + largeHeap.peek()) / 2;
        
    }
}