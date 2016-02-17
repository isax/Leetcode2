public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int totalArea = (D-B)*(C-A) + (G-E)*(H-F);
        
        if(H<=B || C<=E || D<=F || G<=A){
            return totalArea;
        }else{
            return totalArea - (Math.min(H,D)-Math.max(B,F))*(Math.min(C,G)-Math.max(A,E));
        }
    }
}
