public class Solution {
    public int minArea(char[][] image, int x, int y) {
        int row = image.length;
        int col = image[0].length;
        int leftBound = binarySearchToSmaller(image, 0, y, true);
        int rightBound = binarySearchToLarger(image, y, col-1, true);
        int upperBound = binarySearchToSmaller(image, 0, x, false);
        int lowerBound = binarySearchToLarger(image, x, row-1, false);
        return (rightBound-leftBound+1)*(lowerBound-upperBound+1);
    }
    
    // 
    private int binarySearchToSmaller(char[][] image, int l, int r, boolean searchRow){
        while(l<=r){
            int mid = (l+r)/2;
            
            boolean foundBlack = search(image, mid, searchRow);

            if(foundBlack){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
    
    private int binarySearchToLarger(char[][] image, int l, int r, boolean searchRow){
        while(l<=r){
            int mid = (l+r)/2;
            
            boolean foundBlack = search(image, mid, searchRow);

            if(foundBlack){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return r;
    }
    
    private boolean search(char[][]image, int mid, boolean searchRow){
        int bound = searchRow?image.length:image[0].length;
        boolean found = false;
        for(int i = 0; i<bound; i++){
            if(searchRow && image[i][mid]=='1' || !searchRow && image[mid][i]=='1'){
                found = true;
                break;
            }
        }
        return found;
    }
}
