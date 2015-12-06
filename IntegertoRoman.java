public class Solution {

    // http://blog.csdn.net/linhuanmars/article/details/21145639
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int digit = 1000;
        ArrayList<Integer> digits = new ArrayList<Integer>();
        while(digit>0){ // here must be digit
            digits.add(num/digit);
            num %= digit;
            digit /= 10;
        }
        
        sb.append(convert(digits.get(0), 'M',' ',' '));
        sb.append(convert(digits.get(1), 'C','D','M'));
        sb.append(convert(digits.get(2), 'X','L','C'));
        sb.append(convert(digits.get(3), 'I','V','X'));
        return sb.toString();
    }
    
    private String convert(int digit, char one, char five, char ten){
        StringBuilder sb = new StringBuilder();
        switch(digit){
            case 1:
            case 2:
            case 3:
                for(int i =0 ;i<digit; i++){
                    sb.append(one);
                }
                break;
            case 4:
                sb.append(one);
                sb.append(five);
                break;
            case 5:
            case 6:
            case 7:
            case 8:
                sb.append(five);
                for(int i=0; i<digit-5; i++){
                    sb.append(one);
                }
                break;
            case 9:
                sb.append(one);
                sb.append(ten);
                break;
        }
        return sb.toString();
    }
}
