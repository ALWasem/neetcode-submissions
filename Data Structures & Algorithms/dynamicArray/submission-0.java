class DynamicArray {

    int[] dynamicArray;

    int capacity;

    int size;

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        dynamicArray = new int[this.capacity];
    }

    public int get(int i) {
        return dynamicArray[i];
    }

    public void set(int i, int n) {
        dynamicArray[i] = n;
    }

    public void pushback(int n) {

        if(size == capacity)
            this.resize();

        dynamicArray[size++] = n;
    }

    public int popback() {
        if (size > 0)
            size--;
        
        return dynamicArray[size];
    }

    private void resize() {

        capacity*=2;

        int[] myArray = new int[capacity];

        for(int i = 0; i < size; i++){
            myArray[i] = dynamicArray[i];
        }

        dynamicArray = myArray;

    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
