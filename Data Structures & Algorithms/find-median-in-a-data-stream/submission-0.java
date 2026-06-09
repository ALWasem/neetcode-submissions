class MedianFinder {

    //int size;
    List<Integer> data;

    public MedianFinder() {

        //this.size = 0;
        this.data = new ArrayList<>();
        
    }
    
    public void addNum(int num) {

        data.add(num);
        Collections.sort(this.data);
        //this.size++;
        
    }
    
    public double findMedian() {

        if(data.size() == 1)
            return data.get(0);
        
        if(data.size() % 2 == 0){
            int x = data.get(data.size() / 2);
            int y = data.get(data.size() / 2 - 1);
            return (double) (x + y) / 2;
        }
        else
            return (double) data.get(data.size() / 2);
        
    }
}
