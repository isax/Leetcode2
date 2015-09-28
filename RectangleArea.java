public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        if(E>=C||G<=A||B>=H||F>=D){
            return (C-A)*(D-B) + (G-E)*(H-F);
        }else{
            return (C-A)*(D-B) + (G-E)*(H-F) - (Math.min(D,H) - Math.max(B, F))*(Math.min(C,G) - Math.max(A, E));
        }
    }
}
