/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    
    public int maxPoints(Point[] points) {
        if(points.length==0) return 0;
        
        int max = 0;
        for(int i = 0; i<points.length; i++){
            int localMax = 1;
            int numofSame = 0;
            double ratio = 0.0;
            Map<Double, Integer> map = new HashMap<Double, Integer>();  
            for(int j = i+1; j<points.length; j++){
                if(points[i].x == points[j].x && points[i].y == points[j].y){
                    numofSame++;
                    continue;
                }else if(points[j].x == points[i].x){
                    ratio = (double)Integer.MAX_VALUE;
                }else if(points[j].y == points[i].y){
                    ratio = 0.0;
                }else{
                    ratio =  (double)(points[i].y - points[j].y)/(double)(points[i].x-points[j].x);
                }
                
                if(map.containsKey(ratio)){
                    map.put(ratio, map.get(ratio)+1);
                }else{
                    map.put(ratio, 2);
                }
            }
            for (Integer value : map.values()){
                localMax = Math.max(localMax, value);
            }
            localMax += numofSame;  
            max = Math.max(max, localMax);  
        }  
        return max;  
    }
    
    
    public int maxPointsStrict(Point[] points) {
        if(points.length==0) return 0;
        
        if(checkIfAllSame(points)) return points.length;
        
        int max = 0;
        for(int i = 0; i<points.length; i++){
            for(int j = i+1; j<points.length; j++){
                if(points[i].x == points[j].x && points[i].y == points[j].y){
                    continue;
                }
                int cur = 2;
                for(int n = 0; n<points.length; n++){
                    if(n==i || n==j) continue;
                    int left = (points[j].y-points[i].y)*(points[n].x-points[i].x);
                    int right = (points[j].x-points[i].x)*(points[n].y-points[i].y);
                    if(left==right) cur++;
                }
                max = Math.max(max, cur);
            }
        }
        return max;
    }
    
    private boolean checkIfAllSame(Point[] points){
        for(int i = 1; i<points.length; i++){
            if(points[i].x != points[i-1].x || points[i].y != points[i-1].y){
                return false;
            }
        }
        return true;
    }
}
