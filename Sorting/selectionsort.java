import java.util.*;

public class selectionsort {
    public  static int[] selection(int[] arr){
        for(int i=0;i<arr.length;i++){
            int minIndex=findMinimum(arr,i,arr.length);

            if(i!=minIndex){
                //Swap arr[i] and arr[minIndex]
                int temp=arr[i];
                arr[i]=arr[minIndex];
                arr[minIndex]=temp;
            }
        }   
        return arr;     
    }

    public static int findMinimum(int[] arr,int start, int end){
        int minIdx=start;
        for(int i=start+1;i<end;i++){
            if(arr[minIdx]>arr[i])
            minIdx=i;
        }
        return minIdx;
    }

    public static void main(String args[]){
        int[] arr={15,65,74,15,23,10};
        System.out.println("Array after selection sort");
        arr=selection(arr);
        System.out.println(Arrays.toString(arr));
    }
}
