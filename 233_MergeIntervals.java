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
    // similar to meeting room 2
    public List<Interval> merge(List<Interval> intervals) {
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
            if(!q.isEmpty() && q.peek().end>=intervals.get(i).start){
                Interval peek = q.poll();
                q.offer(new Interval(peek.start, Math.max(peek.end, intervals.get(i).end))); 
            }else{
                q.offer(intervals.get(i));
            }
        }
        return new ArrayList<Interval>(q);
        
    }
    // https://leetcode.com/discuss/33434/a-clean-java-solution
    public List<Interval> merge2(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start-i2.start;
            }
        });
        List<Interval> list = new ArrayList<Interval>();
        if(intervals.size()==0) return list;
        int l = intervals.get(0).start;
        int r = intervals.get(0).end;
        
        for(int i = 1; i<=intervals.size(); i++){
            if(i==intervals.size()) {
                list.add(new Interval(l, r));
                continue;
            }
            if(r>=intervals.get(i).start){
                r = Math.max(r, intervals.get(i).end);
            }else{
                list.add(new Interval(l, r));
                l = intervals.get(i).start;
                r = intervals.get(i).end;
            }
        }
        return list;
    }
}
