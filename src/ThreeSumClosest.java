//Find the sum of 3 adjacent elements (subarray of size 3) that is closest to target = -2.
public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        int closest = nums[0]+nums[1]+nums[2];
        int sum = 0;
        int difference = 0;
        int p1 = 0;
        int p2 = 2;
        while(p2<=nums.length-1){
            for(int i=p1;i<=p2;i++){
                sum+=nums[i];
            }
            p1+=1;
            p2+=1;
            if(sum>target){
                difference = sum - target;
            }
            else{
                difference = target - sum;
            }
            if(closest>target){
                if(closest-target>difference){
                    closest = sum;
                }
            }
            else{
                if(target-closest>difference){
                    closest = sum;
                }
            }
            sum = 0;
        }
        return closest;
    }

    public static void main(String[] args){
        int[] nums = {4,0,5,-5,3,3,0,-4,-5};
        System.out.println(threeSumClosest(nums,-2));
    }
}
