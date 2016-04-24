public final Set<Character> vowels = new HashSet<Character>();
    public String reverseVowels(String s) {
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        
        int l = 0, r = s.length()-1;
        char[] ss = s.toCharArray();
        
        while(l<r){
            while(l<r && !vowels.contains(Character.toLowerCase(ss[l]))){
                l++;
            }
            while(l<r && !vowels.contains(Character.toLowerCase(ss[r]))){
                r--;
            }
            if(l<r){
               swap(ss, l++, r--); 
            }
        }
        return new String(ss);
    }
    
    private void swap(char[] charArray, int l, int r){
        char left = charArray[l];
        charArray[l] = charArray[r];
        charArray[r] = left;
    }
