import java.util.HashSet;

public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set =new HashSet<>();
        int size = 0;
        int left = 0;
        int right = 0;
        for(right=0;right<s.length();right++){
            if(set.add(s.charAt(right))) {
                if (right == s.length() - 1 && size < right - left+1) {
                    size = right - left+1;
                }
                continue;
            }
            else{
                if(size<right-left){
                    size=right-left;
                }
                while (!set.add(s.charAt(right))){
                    set.remove(s.charAt(left));
                    left+=1;
                }
            }
        }
        return size;
    }

    public static void main(String[] args) {

        String s = "abcadefs";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
