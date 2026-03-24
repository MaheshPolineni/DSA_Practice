public class FirstStringOccurance {
    public static int strStr(String haystack, String needle) {
        StringBuilder sb = new StringBuilder();
        int p1=0;
        int p2=0;
        if(haystack == null || haystack.isEmpty()||needle==null || needle.isEmpty())
            return -1;
        while(p2<=haystack.length()-1){
            if(haystack.length()-p2<needle.length()){
                return -1;
            }
            for(int i=0;i<needle.length();i++){
                sb.append(haystack.charAt(p2));
                p2+=1;
            }
            if(needle.equals(sb.toString())){
                return p1;
            }
            else{
                sb=new StringBuilder();
                p1+=1;
                p2 = p1;
            }
            }
        return -1;
    }

    public static void main(String[] args){
        String s1 = "hello";
        String s2 = "ll";
        System.out.println(strStr(s1,s2));
    }
}
