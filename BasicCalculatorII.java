public class Solution {
    // https://leetcode.com/discuss/41902/share-my-java-solution
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        char sign = '+';
        int cur = 0;
        
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch==' ') continue;
            
            if(ch>='0' && ch<='9'){
                cur = ch - '0';
                while(i+1<s.length() && s.charAt(i+1)>='0' && s.charAt(i+1)<='9'){
                    i++;
                    cur = cur*10 + (s.charAt(i)-'0');
                }
                if(sign=='+'){
                    stack.push(cur);
                }else if(sign=='-'){
                    stack.push(-cur);
                }else if(sign=='*'){
                    stack.push(stack.pop()*cur);
                }else{
                    stack.push(stack.pop()/cur);
                }
            }else{
                sign = ch;
            }
        }
        
        int res = 0;
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
    
    // https://leetcode.com/discuss/42903/java-straight-forward-iteration-solution-with-comments-stack
    public int calculateNoStackBetter(String s) {
        int result = 0;
        char preSign = '+';
        int preVal = 0;
        
        for(int i = 0; i<s.length(); i++){
            int cur = 0;
            
            char ch = s.charAt(i);
            // space
            if(ch==' ') continue;
            
            // number
            if(ch>='0' && ch<='9'){
                cur = ch - '0';
                while(i+1<s.length() && s.charAt(i+1)>='0' && s.charAt(i+1)<='9'){
                    i++;
                    cur = cur*10 + (s.charAt(i)-'0');
                }
                
                if(preSign=='*'){
                    preVal = preVal*cur;
                }else if(preSign=='/'){
                    preVal = preVal/cur;
                }else if(preSign=='+'){
                    result += preVal;
                    preVal  = cur;
                }else if(preSign=='-'){
                    result += preVal;
                    preVal  = -cur;
                }
            }else{ // ops
                preSign = ch;
            }
        }
        return result + preVal;
    }
    
    // for cur digit, 
    // if last sign =='*' or '/', we can do the mutiplication or division
    // else, we need to check the sign after the digit
    public int calculateFirst(String s) {
        int result = 0;
        int sign = 1;
        s = s +"+0";
        
        char lastSign = '+';
        int lastNum = 0;
        int cur = 0; // inflight 
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            // space
            if(ch==' ') continue;
            
            // number
            if(ch>='0' && ch<='9'){
                cur = ch - '0';
                while(i+1<s.length() && s.charAt(i+1)>='0' && s.charAt(i+1)<='9'){
                    i++;
                    cur = cur*10 + (s.charAt(i)-'0');
                }
                
                if(lastSign=='*'){
                    cur = lastNum*cur;
                    lastNum = cur;
                }else if(lastSign=='/'){
                    cur = lastNum/cur;
                    lastNum = cur;
                }
                continue;
            }
            
            // sign
            if(ch =='*' || ch=='/'){
                lastNum = cur;
                lastSign = ch;
            }else{ // + or -
                result += cur*sign;
                sign = ch=='+'?1:-1;
                
                lastNum = result;
                lastSign = ch;
            }
        }
        // return result + cur*sign;
        return result;
    }
}
