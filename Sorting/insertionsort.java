import java.util.Arrays;

//In insertion sort we pick the element and put it at its correct position in the sorted array

public class insertionsort {

    public static void insertion(int[] arr){
        for(int i=1;i<arr.length;i++){      //starting from i=1 assuming arr[0] is sorted
            int current=arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>current){
                //System.out.println(Arrays.toString(arr));
                arr[j+1]=arr[j];
                j--;
            }
            //System.out.println("Puting "+current +" at "+(j+1)+Arrays.toString(arr));
            arr[j+1]=current;

        }
    }
    public static void main(String args[]){
        int[] arr={15,65,74,15,23,10};
        System.out.println(Arrays.toString(arr));
        System.out.println("Array after insertion sort");
        insertion(arr);
        System.out.println(Arrays.toString(arr));
    }
}
