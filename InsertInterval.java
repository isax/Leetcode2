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
    // http://blog.csdn.net/linhuanmars/article/details/22238433
    
    // https://leetcode.com/discuss/22929/short-and-straight-forward-java-solution
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<Interval>();
        int size = intervals.size();
        int i = 0;
        while(i<size && intervals.get(i).end<newInterval.start) {
            res.add(intervals.get(i++));
        }
        
        while(i<size && intervals.get(i).start<=newInterval.end) {
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }
        res.add(newInterval);
        for(; i<intervals.size(); i++){
            res.add(intervals.get(i));
        }
        return res;
    }
}
