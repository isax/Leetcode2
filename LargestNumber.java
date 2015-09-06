public class Solution {
    public String largestNumber(int[] nums) {
        StringBuilder res = new StringBuilder();
        
        ArrayList<String> al = new ArrayList<String>();
        for (int i : nums) al.add(i + "");
        
        Collections.sort(al, new MyComparator());
        
        for(String i : al){
            res.append(i);
        }
        
        if (res.toString().charAt(0) == '0') return "0";
        
        return res.toString();
    }
    
    private class MyComparator implements Comparator<String>{
            public int compare(String a_str, String b_str){
                if(a_str.length()==b_str.length()){
                    for(int i = 0; i<a_str.length(); i++){
                        if(a_str.charAt(i)>b_str.charAt(i)){
                            return -1;
                        }else if(a_str.charAt(i)<b_str.charAt(i)){
                            return 1;
                        }
                    }
                    return 0;
                }else{
                    return compare(a_str+b_str, b_str+a_str);
                }
                
            }
        }
}
