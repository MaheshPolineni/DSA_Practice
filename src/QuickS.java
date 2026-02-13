public class QuickS{
    public static int[] partition(int[] array){
        int pivot = array.length-1;
        int left = 0;
        int right = array.length-2;
        while(left<=right){
            while(array[pivot]>array[left] && left<=right){
                left+=1;
            }
            if(array[pivot]<array[right] && left<=right){
                right-=1;
            }
            if(array[pivot]<array[left] && array[pivot]>array[right]){
                int temp=array[left];
                array[left]=array[right];
                array[right]=temp;
            }
            if(left>right || left==right){
                int temp= array[pivot];
                array[pivot]  = array[left];
                array[left] = temp;
                break;
            }
        }
        return array;
    }



    public static int[] quickSort(int[] array){
        if(array.length<=1) {
            return array;
        }
        int pivot = array[array.length-1];
        int pivotIndex = 0;
        partition(array);
        for(int i=0;i< array.length;i++){
            if(array[i]==pivot)
                pivotIndex = i;
            break;
        }

        int[] rightArray = new int[array.length-1-pivotIndex];
        int[] leftArray = new int[pivotIndex];
        for(int i=0;i<leftArray.length;i++)
            leftArray[i] = array[i];
        for(int i=0;i< rightArray.length;i++)
            rightArray[i] = array[pivotIndex+1+i];
        quickSort(leftArray);
        quickSort(rightArray);
        for(int i=0;i<leftArray.length;i++)
             array[i] = leftArray[i];
        for(int i=0;i< rightArray.length;i++)
            array[pivotIndex+1+i] = rightArray[i];

        return array;
    }



    public static void main(String[] args){
        int[] array = {2,3,5,4};
        int[] partionedArray=quickSort(array);
        for(int i=0;i<partionedArray.length;i++){
            System.out.println(partionedArray[i]);
        }
        System.out.println("Quick Sort");
    }
}