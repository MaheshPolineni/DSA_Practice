public class findRepeatedSubstring {

    public static Boolean repeatedSubstringPattern(String s){
        if(s==null || s.isEmpty()){
            return false;
        }
        int i =0;
        int size = s.length();
        String sub = "";
        int p1 = 0;
        int p2 = 1;
        while(p2<s.length()){
            if(s.charAt(p2)!=s.charAt(i)){
                p2+=1;
                continue;
            }
            else{
                i = p2-1;
                sub = s.substring(0,p2);
                p2 = i;
                break;
            }
        }
        if(s.length()%(p2+1)!=0)
            return false;

        while(p2<s.length()){
            for(int j=0;j<sub.length();j++){
                if(s.charAt(p1)==sub.charAt(j)){
                    p1+=1;
                    continue;
                }
                else{
                    return false;
                }
            }
            p2=p1;
        }
        return true;
    }

    public static void main(String[] args){
        String s = "abababa";
        System.out.print(repeatedSubstringPattern(s));
    }
}
