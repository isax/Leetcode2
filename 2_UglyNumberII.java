public class Solution {
    public int nthUglyNumber(int n) {
        List<Integer> list2 = new ArrayList<Integer>(); list2.add(2);
        List<Integer> list3 = new ArrayList<Integer>(); list3.add(3);
        List<Integer> list5 = new ArrayList<Integer>(); list5.add(5);
        int l2 = 0, l3 = 0, l5 = 0;
        
        int curUgly = 1;
        while(n!=1){
            curUgly = Math.min(list2.get(l2), Math.min(list3.get(l3), list5.get(l5)));
            
            if(list2.get(l2)==curUgly){
                l2++;
            }
            if(list3.get(l3)==curUgly){
                l3++;
            }
            if(list5.get(l5)==curUgly){
                l5++;
            }
            
            list2.add(curUgly*2);
            list3.add(curUgly*3);
            list5.add(curUgly*5);
            n--;
        }
        return curUgly;
    }
}
