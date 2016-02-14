class MedianFinder {
    // https://leetcode.com/discuss/65107/share-my-java-solution-logn-to-insert-o-1-to-query
    Queue<Integer> maxHeap = new PriorityQueue<Integer>(10, Collections.reverseOrder());
    Queue<Integer> minHeap = new PriorityQueue<Integer>();
    // Adds a number into the data structure.
    public void addNumMine(int num) {
        if(maxHeap.isEmpty() || num<=maxHeap.peek()){
            maxHeap.offer(num);
        }else{
            minHeap.offer(num);
        }
        
        if(maxHeap.size()>minHeap.size()+1){
            minHeap.offer(maxHeap.poll());
        }else if(maxHeap.size()<minHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }
    
    // if s1==s2, after add will be x+1, x
    // then after add, x+1, x+1
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        
        if(maxHeap.size()<minHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(maxHeap.isEmpty()) return Double.NEGATIVE_INFINITY;
        
        if(maxHeap.size()==minHeap.size()){
            return (maxHeap.peek()+minHeap.peek())/2.0;
        }else{
            return (double)maxHeap.peek();
        }
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
