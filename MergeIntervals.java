/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    
    //https://leetcode.com/discuss/33434/a-clean-java-solution
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals==null || intervals.size() ==0) return new ArrayList<Interval>();
        Collections.sort(intervals, new Comparator<Interval>(){
           public int compare(Interval i1, Interval i2){
               return i1.start - i2.start;
           } 
        });
        
        List<Interval> list = new ArrayList<Interval>();
        //Interval pre = null;
        for(int i = 0; i<intervals.size(); i++){
            Interval interval = intervals.get(i);
            if(list.isEmpty() || list.get(list.size()-1).end<interval.start){
                list.add(interval);
            }else{
                Interval pre = list.get(list.size()-1);
                list.remove(list.size()-1);
                list.add(new Interval(pre.start, Math.max(interval.end, pre.end))); // here need to find the maxmium end
            }
        }
        return list;
    }
    
    
    // similar to meeting room 2
    public List<Interval> mergeMine(List<Interval> intervals) {
        if(intervals==null || intervals.size() ==0) return new ArrayList<Interval>();
        Collections.sort(intervals, new Comparator<Interval>(){
           public int compare(Interval i1, Interval i2){
               return i1.start - i2.start;
           } 
        });
        
        PriorityQueue<Interval> q = new PriorityQueue(intervals.size(), new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i2.end - i1.end;
            }
        });
        
        for(int i = 0; i<intervals.size(); i++){
            Interval interval = intervals.get(i);
            if(!q.isEmpty() && q.peek().end>=interval.start){
                Interval peek = q.poll();
                q.offer(new Interval(peek.start, Math.max(interval.end, peek.end))); // here need to find the maxmium end
            }else{
                q.offer(interval);
            }
        }
        List<Interval> list = new ArrayList<Interval>(q);
        return list;
    }
}
