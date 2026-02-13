public class MergeS{
    public static int[] merge(int[] leftArray, int[] rightArray){
        int left = 0;
        int right =0;
        int index=0;
        int[] mergedArray = new int[leftArray.length+rightArray.length];
        while(left<= leftArray.length-1 && right < rightArray.length){
            if(leftArray[left]<rightArray[right]){
                mergedArray[index]=leftArray[left];
                index+=1;
                left+=1;
            }
            else{
                mergedArray[index]=rightArray[right];
                index+=1;
                right+=1;
            }
        }
        while (left < leftArray.length) {
            mergedArray[index++] = leftArray[left++];
        }

        while (right < rightArray.length) {
            mergedArray[index++] = rightArray[right++];
        }
        return mergedArray;
    }


    public static int[] mergesort(int[] array){
        if(array.length<=1){
            return array;
        }
        int mid = (array.length)/2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[array.length-mid];
        for(int i=0;i<leftArray.length;i++){
            leftArray[i]=array[i];
        }
        for(int i=mid;i<array.length;i++){
            rightArray[i-mid]=array[i];
        }
        leftArray=mergesort(leftArray);
       rightArray= mergesort(rightArray);
        return merge(leftArray,rightArray);
    }


    public static void main(String[] args){
        int[] array = {5,4,3,2,1};
        int[] sortedArray = mergesort(array);
        for(int i=0;i<sortedArray.length;i++){
            System.out.println(sortedArray[i]);
        }
    }
}