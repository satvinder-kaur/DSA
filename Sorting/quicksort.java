import java.util.Arrays;

public class quicksort {

    public static int partition(int[] arr,int low , int high){
        int pivot=arr[high];
        int i=low-1;    //counter i will keep track of elements that are smaller than pivot element
        for(int j=low;j<high;j++){
            if(arr[j]<pivot){
                i++;
                //swap
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        //Positioning pivot at its correct position
        i++;
        int temp=arr[i];
        arr[i]=pivot;
        arr[high]=temp;
        return i;

    }

    public static void quick(int[] arr,int low,int high){
        if(low<high){
            int pivotIdx=partition(arr,low ,high);

            quick(arr,low,pivotIdx-1);
            quick(arr,pivotIdx+1,high);
        }
    }

    
    public static void main(String args[]){
        int[] arr={15,65,15,74,23,10};
        System.out.println(Arrays.toString(arr));
        System.out.println("Array after quick sort");
        quick(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
