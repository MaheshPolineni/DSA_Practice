public class SlidingWindowMaxThree {
    static int maxSum(int[] arr, int range){
        int max = 0;
        int sum = 0;
        int left = 0;
        int right = range-1;
        int windowSum = 0;

        for(int i=0;i<=range-1;i++){
            windowSum+=arr[i];
            max+=arr[i];
        }


        while(right<arr.length-1){
            right+=1;
            sum = windowSum-arr[left]+arr[right];
            windowSum = sum;
            left+=1;
            if(windowSum>max){
                max=windowSum;
            }
            sum = 0;
        }
        return max;
    }
    public static void main(String[] args){
        int[] arr = {100, -90, 100, -90, 100, -90, 100};
        int k = 3;
        System.out.println(maxSum(arr,k));
    }
}
