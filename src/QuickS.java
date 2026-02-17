public class QuickS{

    public static int duplicateOccurance(int[] array, int value){
        int count = 0;
        int index=0;
        for(int i = 0;i<array.length;i++){
            if(array[i]==value){
                count+=1;
            }
        }
        for(int i = 0;i<array.length;i++){
            if(array[i] == value){
                count-=1;
            }
            if(count==0) {
                index = i;
                break;
            }
        }
        return index;
    }
    public static int[] partition(int[] array){
        int pivot = array.length-1;
        int left = 0;
        int right = array.length-2;
        while(left<=right){
            while(array[pivot]>=array[left] && left<=right){
                left+=1;
            }
            if(array[pivot]<array[right] && left<=right && left<array.length-1){
                right-=1;
            }
            if(right>left && array[pivot]<array[left] && array[pivot]>=array[right]){
                int temp=array[left];
                array[left]=array[right];
                array[right]=temp;
            }
            if(left>=right){
                int temp= array[pivot];
                array[pivot]  = array[left];
                array[left] = temp;
                break;
            }
        }
        return array;
    }



    public static int[] quicksort(int[] array){
        if(array.length<=1) {
            return array;
        }
        int pivot = array[array.length-1];
        int pivotIndex = 0;
        partition(array);
        pivotIndex = duplicateOccurance(array,pivot);

        int[] rightArray = new int[array.length-1-pivotIndex];
        int[] leftArray = new int[pivotIndex];
        for(int i=0;i<leftArray.length;i++)
            leftArray[i] = array[i];
        for(int i=0;i< rightArray.length;i++)
            rightArray[i] = array[pivotIndex+1+i];
        quicksort(leftArray);
        quicksort(rightArray);
        for(int i=0;i<leftArray.length;i++)
             array[i] = leftArray[i];
        for(int i=0;i< rightArray.length;i++)
            array[pivotIndex+1+i] = rightArray[i];

        return array;
    }



    public static void main(String[] args){
        int[] array = {2, 3, 2, 1, 2};
        int[] fun1=quicksort(array);
        for(int i=0;i<fun1.length;i++){
            System.out.println(fun1[i]);
        }
    }
}