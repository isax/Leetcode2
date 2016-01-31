public class Solution {
    // https://leetcode.com/discuss/13610/share-my-concise-c-solution-less-than-20-lines
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();  
        if(words==null || words.length==0) return res;
        
        int last = 0;
        int i = 0;
        while(i<words.length){
            int len = -1;
            while(i<words.length && len + 1 + words[i].length()<= maxWidth){
                len += 1 + words[i].length(); // len is "oneword anotherword", with " " in between 
                i++;
            }
                
            int space = 1;
            int extra = 0;
            if(i-last-1>0 && i!=words.length){ // more than one word && not last line
                space = (maxWidth-len)/(i-last-1) + 1;
                extra = (maxWidth-len)%(i-last-1);
            }
            
            StringBuilder str = new StringBuilder(); 
            str.append(words[last]);
            for(int j = last+1; j<i; j++){
                for(int k=0;k<space;k++) {
                    str.append(" ");
                }
                if(extra>0) {
                    str.append(" ");
                    extra--;
                }
                str.append(words[j]);
            }
            for(int j=str.length();j<maxWidth;j++)  // for single word in that line, need to add space on the right side
            {  
                str.append(" ");  
            } 
            res.add(str.toString());
                
            last=i;
        }
        return res;
    }
    
    // http://blog.csdn.net/linhuanmars/article/details/24063271
    public List<String> fullJustify2(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();  
        if(words==null || words.length==0) return res;
        
        int count = 0; 
        int last = 0;
        for(int i=0;i<words.length;i++){
            if(count+words[i].length()+(i-last)>maxWidth){
                int space = 0;
                int extra = 0;
                if(i-last-1>0){ // more than one word
                    space = (maxWidth-count)/(i-last-1);
                    extra = (maxWidth-count)%(i-last-1);
                }
                StringBuilder str = new StringBuilder(); 
                for(int j = last; j<i; j++){
                    str.append(words[j]);
                    if(j<i-1){// not the end of word in this line
                        for(int k=0;k<space;k++) {
                            str.append(" ");
                        }
                        if(extra>0) {
                            str.append(" ");
                            extra--;
                        }
                    }
                }
                for(int j=str.length();j<maxWidth;j++)  // for single word in that line, need to add space on the right side
                {  
                    str.append(" ");  
                } 
                res.add(str.toString());  
                count=0;  
                last=i;
            }
            count += words[i].length();
        }
        // for last line
        StringBuilder str = new StringBuilder();  
        for(int i=last;i<words.length;i++) 
        {  
            str.append(words[i]);  
            if(str.length()<maxWidth)  str.append(" ");  
        } 
        for(int i=str.length();i<maxWidth;i++)  
        {  
            str.append(" ");  
        } 
        res.add(str.toString()); 
        return res;
    }
}
