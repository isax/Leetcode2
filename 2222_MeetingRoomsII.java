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
    // greedy but hard to prove: https://leetcode.com/discuss/70998/java-ac-solution-greedy-beats-92-03%25
    
    // https://leetcode.com/discuss/50911/ac-java-solution-using-min-heap
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals==null || intervals.length==0){
            return 0;
        }
        
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        
        Queue<Interval> q = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.end-i2.end;
            }
        });
        
        for(int i = 0; i<intervals.length; i++){
            Interval interval = intervals[i];
            if(!q.isEmpty() && q.peek().end<=interval.start){
                q.poll();
            }
            q.offer(interval);
        }
        
        return q.size();
    }
}
