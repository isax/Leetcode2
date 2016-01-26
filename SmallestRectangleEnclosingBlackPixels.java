public class Solution {
    // https://leetcode.com/discuss/71898/1ms-java-binary-search-dfs-is-4ms
    // https://leetcode.com/discuss/68246/c-java-python-binary-search-solution-with-explanation
    public int minArea(char[][] image, int x, int y) {
        int m = image.length, n = image[0].length;
        int colLeft = bs(image, 0, y, 0, m-1, true, true);
        int colRight = bs(image, y, n-1, 0, m-1, true, false);
        int rowLow = bs(image, 0, x, colLeft, colRight, false, true);
        int rowHigh = bs(image, x, m-1, colLeft, colRight, false, false);
        
        return (colRight-colLeft+1)*(rowHigh-rowLow+1);
    }
    
    private int bs(char[][]image, int l, int h, int min, int max, boolean isHorizontal, boolean goSmaller){
        int row = image.length;
        int col = image[0].length;
        
        while(l<=h){
            int mid = (l+h)/2;
            boolean found = false;
            for(int i = min; i<=max; i++){
                if((isHorizontal? image[i][mid]:image[mid][i])=='1'){
                    found = true;
                    break;
                }
            }
            if(found==goSmaller){
                h = mid-1;
            }else{
                l = mid+1;
            }
        }
        return goSmaller?l:h;
    }
    /*
    private int bsLarger(char[][]image, int l, int h, int min, int max, boolean isHorizontal, boolean goSmaller ){
        int row = image.length;
        int col = image[0].length;
        
        while(l<=h){
            int mid = (l+h)/2;
            boolean found = false;
            for(int i = min; i<=max; i++){
                if((isHorizontal? image[i][mid]:image[mid][i])=='1'){
                    found = true;
                    break;
                }
            }
            if(found==goSmaller){
                //l = mid+1;
                h = mid-1;
            }else{
                //h = mid-1;
                l = mid+1;
            }
        }
        return h;
    }*/
}
