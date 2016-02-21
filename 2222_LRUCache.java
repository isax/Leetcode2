public class LRUCache {
    // https://github.com/isax/Leetcode2/blob/master/LRUCache.java
    private Map<Integer, Node> cache;
    private Node head;
    private Node tail;
    private int capacity;
    
    public LRUCache(int capacity) {
        this.cache = new HashMap<Integer, Node>();
        
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            removeNode(node);
            addTail(node); 
            return node.val;
        }else {
            return -1;
        }
    }
    
    private void addTail(Node node){
        Node prev = tail.prev;
        node.prev = prev;
        node.next = tail;
        
        prev.next = node;
        tail.prev = node;
    }
    
    private void removeNode(Node node){
        Node prev = node.prev;
        Node next = node.next;
        
        next.prev = prev;
        prev.next = next;
    }
    
    public void set(int key, int value) {
        if(cache.containsKey(key)) {
            removeNode(cache.get(key));
        }
        Node newNode = new Node(key, value);
        addTail(newNode);
        cache.put(key, newNode);
        
        if(cache.size()>capacity){
            cache.remove(head.next.key); /////////////////////!!!!!!!!!!!
            removeNode(head.next);
        }
    }
    
    private class Node{
        int key; ////////////////////////////!!!!!!!!!!!
        int val;
        Node prev;
        Node next;
        
        Node(){}
        
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    
    /* CHEAT 2 https://leetcode.com/discuss/1188/java-is-linkedhashmap-considered-cheating 
    
    This linked list defines the iteration ordering, which is normally the order in which keys were inserted into the map (insertion-order). Note that insertion order is not affected if a key is re-inserted into the map. (A key k is reinserted into a map m if m.put(k, v) is invoked when m.containsKey(k) would return true immediately prior to the invocation.)
    private Map<Integer, Integer> cache;
    private int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        // accessOrder - the ordering mode - true for access-order, false for insertion-order
        cache = new java.util.LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
            // eldest - The least recently inserted entry in the map, 
            // or if this is an access-ordered map, the least recently accessed entry
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest){
                return size()>capacity;
            }
        };
    }
    public int get(int key) {
        if(cache.containsKey(key)) {
            return cache.get(key);
        }else {
            return -1;
        }
    }
    public void set(int key, int value) {
        cache.put(key, value);
    }
    */
    
    /* Cheating and use Linked Hash Map 
    private Map<Integer, Integer> cache;
    private int capacity;
    
    public LRUCache(int capacity) {
        cache = new java.util.LinkedHashMap<Integer, Integer>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)) {
            int value = cache.get(key);
            cache.remove(key);
            cache.put(key, value);
            return value;
        }else {
            return -1;
        }
    }
    
    public void set(int key, int value) {
        cache.remove(key); // return null if no mapping
        cache.put(key, value);
        
        if(cache.size() > capacity){
            cache.remove(cache.keySet().iterator().next());
        }
    }*/
}
