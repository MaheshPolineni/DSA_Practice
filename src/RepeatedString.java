public class RepeatedString {
    public static long repeatedString(String s, long n) {
        long count = n/s.length();
        long remCount = n%s.length();
        long aCount = 0;
        for(int i = 0; i<s.length();i++){
            if(s.charAt(i)=='a'){
                aCount+=1;
            }
        }
        aCount = aCount*count;
        for(int i=0;i<remCount;i++){
            if(s.charAt(i)=='a')
                aCount+=1;
        }
        return aCount;
    }
    public static void main(String[] args){
        String s = "acb";
        long n = 10L;
        System.out.println(repeatedString(s,n));
    }
}
