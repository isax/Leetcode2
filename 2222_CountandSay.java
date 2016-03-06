public String countAndSay(int n) {
        String prev = "1";
        for(int i = 2; i<=n; i++){
            StringBuilder cur = new StringBuilder();
            int count = 1;
            for(int j = 1; j<=prev.length(); j++){
                if(j==prev.length() || prev.charAt(j) != prev.charAt(j-1)){
                    cur.append(""+count).append(prev.charAt(j-1));
                    count = 1;
                }else{
                    count++;
                }
            }
            prev = cur.toString();
        }
        return prev;
    }
