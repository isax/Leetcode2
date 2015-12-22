public class LRUCache {
    
    // https://leetcode.com/discuss/8645/my-o-1-solution-in-java
    
    private int capacity;
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0, 0); // dummy
        tail = new Node(0, 0); // dummy
        
        //initialize
        head.next = tail;
        tail.prev = head;
        
        map = new HashMap<Integer, Node>();
        count = 0;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            moveToHead(map.get(key));
            return map.get(key).val;
        }else{
            return -1;
        }
    }
    
    private void moveToHead(Node node){
        if(head.next==node) return; // head.next already
        
        node.prev.next = node.next;
        node.next.prev = node.prev;
        
        node.prev = head;
        node.next = head.next;
        
        head.next.prev = node;
        head.next = node;
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)) {
            map.get(key).val = value; // set value if changed
            moveToHead(map.get(key));
        }else{
            Node newNode = new Node(key, value);
            
            if(map.size()==capacity && capacity>0){ // remove tail
                map.remove(tail.prev.key);
                
                tail.prev = tail.prev.prev;
                tail.prev.next = tail;
            }
            
            newNode.prev = head;
            newNode.next = head.next;
            head.next.prev = newNode;
            head.next = newNode;
            
            map.put(key, newNode);
        }
    }
    
    
    private class Node{
        Node prev;
        Node next;
        int key;
        int val;
        
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
}
