public class MedianofTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArray = new int[nums1.length+nums2.length];
        int left = 0;
        int right = 0;
        int index = 0;
        if(mergedArray.length<1)
            return 0;
        while(left<nums1.length && right<nums2.length){
            if(nums1[left]<nums2[right]){
                mergedArray[index] = nums1[left];
                left+=1;
                index+=1;
            }
            else{
                mergedArray[index] = nums2[right];
                right+=1;
                index+=1;
            }
        }
        while(left< nums1.length)
            mergedArray[index++]=nums1[left++];
        while(right< nums2.length)
            mergedArray[index++] = nums2[right++];
        if(mergedArray.length%2==0)
            return (double) (mergedArray[mergedArray.length/2]+ mergedArray[(mergedArray.length/2)-1])/2;
        else
            return mergedArray[mergedArray.length/2];
    }

    public static void main(String[] args) {
        int[] arr1 = {};
        int[] arr2 = {};
        System.out.println(findMedianSortedArrays(arr1,arr2));
    }
}
