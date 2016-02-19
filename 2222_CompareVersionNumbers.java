public class Solution {
    // https://leetcode.com/discuss/73683/my-simple-java-solution
    public int compareVersion(String version1, String version2) {
        int i = 0, j = 0;
        while(i<version1.length() || j<version2.length()){
            int val1 = 0;
            while(i<version1.length() && version1.charAt(i)!='.'){
                val1 = val1*10 + (version1.charAt(i++)-'0');
            }
            
            int val2 = 0;
            while(j<version2.length() && version2.charAt(j)!='.'){
                val2 = val2*10 + (version2.charAt(j++)-'0');
            }
            
            if(val1!=val2){
                return val1-val2>0?1:-1;
            }
            i++; j++;
        }
        return 0;
    }
    
    // https://leetcode.com/discuss/50309/my-java-solution-without-split
    public int compareVersion2(String version1, String version2) {
        String[] a = version1.split("\\.");
        String[] b = version2.split("\\.");
        
        for(int i = 0; i<a.length || i<b.length; i++){
            int val1 = i<a.length?Integer.parseInt(a[i]):0;
            int val2 = i<b.length?Integer.parseInt(b[i]):0;
            
            if(val1!=val2){
                return val1-val2>0?1:-1;
            }
        }
        return 0;
    }
    
    public int compareVersionMine(String version1, String version2) {
        List<Integer> list1 = split(version1);
        List<Integer> list2 = split(version2);
        
        for(int i = 0; i<list1.size() || i<list2.size(); i++){
            int a = i<list1.size()?list1.get(i):0;
            int b = i<list2.size()?list2.get(i):0;
            
            if(a!=b){
                return a-b>0?1:-1;
            }
        }
        return 0;
    }
    
    private List<Integer> split(String version){
        List<Integer> list = new ArrayList<Integer>();
        int last = 0;
        for(int i = 0; i<=version.length(); i++){
            if(i==version.length()||version.charAt(i)=='.'){
                list.add(Integer.parseInt(version.substring(last, i)));
                last = i+1;
            }
        }
        return list;
    }
}
