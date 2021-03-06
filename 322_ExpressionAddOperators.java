public class Solution {
    //313
    private void helper(String num, int target, long res, long pre, int cur, StringBuilder sb, List<String> list){
        if(cur==num.length()){
            if(res==target){
                list.add(sb.toString());
            }
            return;
        }
        
        long nextNum = 0;
        for(int i = cur; i<num.length(); i++){
            if(num.charAt(cur)=='0' && i!=cur) break;///////////
            
            nextNum = nextNum*10 + (num.charAt(i)-'0');
            int len = sb.length();
            
            if(cur==0){/////////////
                sb.append(nextNum);
                helper(num, target, res+nextNum, nextNum, i+1, sb, list);
                sb.setLength(len);
                continue;
            }
            
            //+
            sb.append("+").append(nextNum);
            helper(num, target, res+nextNum, nextNum, i+1, sb, list);
            sb.setLength(len);
            
            //-
            sb.append("-").append(nextNum);
            helper(num, target, res-nextNum, -nextNum, i+1, sb, list);
            sb.setLength(len);
            
            //*
            sb.append("*").append(nextNum);
            helper(num, target, res+pre*nextNum-pre, pre*nextNum, i+1, sb, list);
            sb.setLength(len);
        }
    }
    
    // https://github.com/isax/Leetcode2/blob/master/ExpressionAddOperators.java
    public List<String> addOperators(String num, int target) {
        List<String> list = new ArrayList<String>();
        helper(0, num, target, 0, 0, new StringBuilder(), list);
        return list;
    }
    
    private void helper(long preValue, String num, int target, int cur, long prepreValue, StringBuilder sb, List<String> list){
        if(cur==num.length()){
            if(preValue==target){
                list.add(sb.toString());
            }
            return;
        }
        
        for(int i = cur; i<num.length(); i++){
            if(num.charAt(cur)=='0' && i!=cur) break;
            // "105" 5
            // ["1*0+5","1*5","10-5"]
            
            
            long curNum = Long.parseLong(num.substring(cur, i+1));
            
            int len = sb.length();
            
            if(cur==0){
                sb.append(curNum);
                helper(preValue+curNum, num, target, i+1, preValue, sb, list);
                sb.setLength(len);
            }else{
                // + 
                sb.append("+" + curNum);
                helper(preValue+curNum, num, target, i+1, preValue, sb, list);
                sb.setLength(len);
                
                //-
                sb.append("-" + curNum);
                helper(preValue-curNum, num, target, i+1, preValue, sb, list);
                sb.setLength(len);
                
                //*
                sb.append("*" + curNum);
                helper(preValue*curNum-prepreValue*curNum+prepreValue, num, target, i+1, prepreValue, sb, list);
                sb.setLength(len);
            }
        }
    }
}
