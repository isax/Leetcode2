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
    
    // http://blog.csdn.net/linhuanmars/article/details/21060933
    public int maxPoints(Point[] points) {
        if(points.length==0 || points.length==1) return points.length;
        
        int max = 0;
        
        for(int i = 0; i<points.length; i++){
            Map<Double, Integer> hm = new HashMap<Double, Integer>();
            int add = 0; // to add the # of same points as i
            int localMax = 1;
            
            for(int j = i+1; j<points.length; j++){
                if(points[i].x==points[j].x && points[i].y==points[j].y) {
                    add++;
                    continue;
                }
                
                double slope = 0.0;
                if(points[i].x==points[j].x){
                    slope = (double)Integer.MAX_VALUE;
                }else if(points[i].y==points[j].y){
                    slope = 0.0;
                }else{
                    slope = (double)(points[i].y - points[j].y)/(double)(points[i].x-points[j].x);
                    //if(slope==-0.0) slope = 0.0;
                }
                
                if(!hm.containsKey(slope)){
                    hm.put(slope, 2);
                }else{
                    hm.put(slope, hm.get(slope)+1);
                }
            }
            
            for(int count : hm.values()){
                localMax = Math.max(count, localMax);
            }
            max = Math.max(localMax+add, max);
        }
        return max;
    }
    
    public int maxPointsStrict(Point[] points) {
        if(points.length==0 || points.length==1) return points.length;
        
        if(allSamePoints(points)){
            return points.length;
        }
        
        int max = 0;
        
        // as long as there are two points that aren't the same in the set, we are able to find the max
        for(int i = 0; i<points.length; i++){
            for(int j = i+1; j<points.length; j++){
                //double slope = (double)(points[i].y - point[j].y)/(double)(points[i].x-points[j].x);
                //double b = points[i].y-slope*points[i].x;
                
                if(points[i].x==points[j].x && points[i].y==points[j].y) continue; // this will be considered when i and j are not the same
                
                int count = 2;
                for(int k = 0; k<points.length; k++){
                    if(k==i || k==j) continue;
                    
                    if((points[k].x - points[i].x)*(points[j].y - points[i].y) == (points[k].y - points[i].y)*(points[j].x - points[i].x)){
                        count++;
                    }
                }
                max = Math.max(count, max);
            }
        }
        return max;
    }
    
    
    private boolean allSamePoints(Point[] points){
        for(int i = 0; i<points.length; i++){
            for(int j = i+1; j<points.length; j++){
                 if(points[i].x!=points[j].x || points[i].y!=points[j].y) return false;
            }
        }
        return true;
    }
}
