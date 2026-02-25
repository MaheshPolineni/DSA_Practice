public class DynamicSW {
    public static int minSubArrayLen(int target, int[] nums) {
        int length=Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        int right = 0;
        while(right < nums.length){
            while (sum<target){
                sum+=nums[right];
                right+=1;
            }
            if(sum==target && length>right-left){
                length = right-left;
            }
            while(sum>target){
                if(left<=nums.length) {
                    sum -= nums[left];
                        left += 1;
                }
            }
        }
        if(length == Integer.MAX_VALUE)
            return -1;
        return length;
    }
    public static void main(String[] args){
        int [] arr = {5, 9, 1, 6, 2};
        System.out.println(minSubArrayLen(6,arr));
    }
}
