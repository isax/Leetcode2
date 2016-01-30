public class Solution {
    // https://leetcode.com/discuss/73683/my-simple-java-solution
    public int compareVersionWithSplit(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        int l1 = v1.length;
        int l2 = v2.length;
        
        for(int i = 0; i<Math.max(l1, l2); i++){
            int val1 = i < l1?Integer.parseInt(v1[i]):0;
            int val2 = i < l2?Integer.parseInt(v2[i]):0;
            
            if(val1<val2) return -1;
            else if(val1>val2) return 1;
        }
        return 0;
    }
    
    // https://leetcode.com/discuss/50309/my-java-solution-without-split
    public int compareVersion(String version1, String version2) {
        int len1 = version1.length(),len2 = version2.length();
        int i = 0,j = 0;
        while(i<len1 || j<len2){
            int temp1 = 0;
            int temp2 = 0;
            
            while(i<len1 && version1.charAt(i) != '.'){
                temp1 = temp1*10 + version1.charAt(i)-'0';
                i++;
            }
            while(j<len2 && version2.charAt(j) != '.'){
                temp2 = temp2*10 + version2.charAt(j)-'0';
                j++;
            }
            
            if(temp1<temp2) return -1;
            else if(temp1>temp2) return 1;
            
            i++;
            j++;
        }
        return 0;
    }
}
