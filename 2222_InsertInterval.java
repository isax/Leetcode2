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
        List<Interval> list = new ArrayList<Interval>();
        int size = intervals.size();
        int i = 0;
        while(i<size && intervals.get(i).end<newInterval.start){
            list.add(intervals.get(i++));
        }
        
        while(i<size && intervals.get(i).start<=newInterval.end){
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }
        list.add(newInterval);
        
        for(; i<size; i++){
            list.add(intervals.get(i));
        }
        return list;
    }
    
    public List<Interval> insertBAD(List<Interval> intervals, Interval newInterval) {
        List<Interval> list = new ArrayList<Interval>();
        
        for(int i = 0; i<intervals.size(); i++){
            if(intervals.get(i).start>newInterval.end){
                list.add(newInterval);
                list.add(intervals.get(i));
                copy(intervals, list, i+1);
                return list;
            }
            
            if(intervals.get(i).end<newInterval.start){
                list.add(intervals.get(i));
            }else{
                newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
                if(newInterval.end<=intervals.get(i).end){
                    newInterval.end = intervals.get(i).end;
                    list.add(newInterval);
                    copy(intervals, list, i+1);
                    return list;
                }
            }
        }
        list.add(newInterval);
        return list;
    }
    
    private void copy(List<Interval> intervals, List<Interval> list, int i){
        for(; i<intervals.size(); i++){
            list.add(intervals.get(i));
        }
    }
}
