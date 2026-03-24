public class MedianSlidingWindow {
    public static double[] medianSlidingWindow(int[] nums, int k) {
        double[] median = new double[nums.length-2];
        int index = 0;
        int subIndex = 0;
        int[] subArray = new int[k];
        int p1 = 0;
        int p2 = k-1;
        while(p2<=nums.length-1) {
            for (int i = p1; i <= p2; i++) {
                subArray[subIndex] = nums[i];
                subIndex += 1;
                System.out.println(subArray[subIndex]);
            }
            for(int n = 0; n<subArray.length;n++){
            for (int j = 0; j <= subArray.length - 1-n; j++) {
                if (j == subArray.length - 1) {
                    break;
                }
                if (subArray[j] > subArray[j + 1]) {
                    int temp = subArray[j];
                    subArray[j] = subArray[j + 1];
                    subArray[j + 1] = temp;
                }
            }
        }
            subIndex = 0;
            p1+=1;
            p2+=1;
        }
        return new double[0];
    }

    public static void main (String[] args){
        int[] nums = {3,5,2,6,5};
        medianSlidingWindow(nums,3);
    }
}
