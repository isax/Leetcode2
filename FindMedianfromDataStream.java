class MedianFinder {
    
    Queue<Integer> heap1 = new PriorityQueue<Integer>(10, Collections.reverseOrder());
    Queue<Integer> heap2 = new PriorityQueue<Integer>();

    // Adds a number into the data structure.
    public void addNumMine(int num) {
        if(heap1.size()==heap2.size()){
            if(heap2.isEmpty() || num<=heap2.peek()){
                heap1.offer(num);
            }else{
                heap2.offer(num);
                heap1.offer(heap2.poll());
            }
        }else{ // size1>size2
            if(num>=heap1.peek()){
                heap2.offer(num);
            }else{
                heap1.offer(num);
                heap2.offer(heap1.poll());
            }
        }
    }
    // https://leetcode.com/discuss/65107/share-my-java-solution-logn-to-insert-o-1-to-query
    public void addNum(int num) {
        heap1.offer(num);
        heap2.offer(heap1.poll());
        if(heap1.size()<heap2.size()){
            heap1.offer(heap2.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(heap1.isEmpty()) return Double.MIN_VALUE;
        if(heap1.size()==heap2.size()){
            //return (heap1.peek()+heap2.peek())/(double)2;
            return (heap1.peek()+heap2.peek())/2.0;
        }else{
            return heap1.peek();
        }
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
