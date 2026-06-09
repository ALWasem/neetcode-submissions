class Node {

    Node left;
    Node right;
    int key;
    int value;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
        left = null;
        right = null;
    }

    public Node(){
        left = null;
        right = null;
    }

}

class LRUCache {

    int capacity;
    int currCapacity;
    Map<Integer, Node> cache = new HashMap<>();

    Node LRU;
    Node MRU;

    public LRUCache(int capacity) {

        this.capacity = capacity;
        this.currCapacity = 0;

        LRU = new Node();
        MRU = new Node();

        LRU.right = MRU;
        MRU.left = LRU;
        
    }

    public void insert(Node node){

        Node prev = MRU.left;

        MRU.left = node;
        node.left = prev;
        node.right = MRU;
        prev.right = node;

    }

    public void remove(Node node){

        node.left.right = node.right;
        node.right.left = node.left;   

    }
    
    public int get(int key) {

        if (cache.containsKey(key)) {
            Node getNode = cache.get(key);

            remove(getNode);
            insert(getNode);

            return getNode.value;
        }

        return -1;
        
    }
    
    public void put(int key, int value) {

        if (cache.containsKey(key))
            remove(cache.get(key));

        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        insert(newNode);

        if(cache.size() > this.capacity){
            Node lru = LRU.right;
            remove(lru);
            cache.remove(lru.key);
        }
        
    }
}
