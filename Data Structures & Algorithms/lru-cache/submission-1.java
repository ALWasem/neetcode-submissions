class Node {

    int key;
    int value;
    Node prev;
    Node next;

    public Node(){
        this.prev = null;
        this.next = null;
    }

    public Node(int key, int value){
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }

}

class LRUCache {

    int capacity;

    Map<Integer, Node> cache;

    Node LRU;
    Node MRU;

    public LRUCache(int capacity) {

        this.capacity = capacity;

        this.cache = new HashMap<>();

        LRU = new Node();
        MRU = new Node();

        LRU.next = MRU;
        MRU.prev = LRU;
        
    }

    public void insert(Node node){

        Node prev = MRU.prev;

        node.next = MRU;
        node.prev = prev;
        MRU.prev = node;
        prev.next = node;

    }

    public void remove(Node node){

        node.prev.next = node.next;
        node.next.prev = node.prev;

    }
    
    public int get(int key) {

        if(cache.containsKey(key)){
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.value;
        }

        return -1;
        
    }
    
    public void put(int key, int value) {

        if(cache.containsKey(key)){
            Node oldNode = cache.get(key);
            remove(oldNode);
        }

        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        insert(newNode);

        if(cache.size() > this.capacity){
            Node lru = LRU.next;
            remove(lru);
            cache.remove(lru.key);
        }

    }
}
