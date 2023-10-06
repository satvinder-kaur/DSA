import java.util.Arrays;

//In merge sort we divide array in two parts ,sort the halves and merge them

public class mergesort {

    //In merge fuction we will create two new arrays-left array and right array 
    //and compare the elements of two arrays and insert them sequentially in the resulting array
    public static void merge(int[] arr,int l,int m ,int r){
        int leftSize=m-l+1;       //Eg if left=0 and m=4 then there will be 5 elements
        int rightSize=r-m;
        int[] leftArr=new int[leftSize];
        int[] rightArr=new int[rightSize];

        //Insert values in both the arrays
        for(int i=0;i<leftSize;i++){
            leftArr[i]=arr[l+i];
        }
        for(int j=0;j<rightSize;j++){
            rightArr[j]=arr[m+1+j];
        }

        //create pointers for traversing three arrays namely leftArr,rightArr,arr
        int i=0,j=0,k=l;        //*****Note***** k should be equal to the starting index i.e. l
        while(i<leftSize && j<rightSize){
            if(leftArr[i]<rightArr[j]){
                arr[k]=leftArr[i];
                i++;k++;
            }
            else{
                arr[k]=rightArr[j];
                j++;k++;
            }
        }

        //Check if elements are left in leftArr or rightArr
        while(i<leftSize){
            arr[k]=leftArr[i];
            i++;k++;
        }
        while(i<rightSize){
            arr[k]=rightArr[j];
            j++;k++;
        }

    }

    public static void mergeSort(int[] arr,int left,int right){
        if(left<right){
            int mid=(left+right)/2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr,left,mid,right);
        }
        
    }
    

    public static void main(String args[]){
        int[] arr={15,65,15,74,23,10};
        System.out.println(Arrays.toString(arr));
        System.out.println("Array after merge sort");
        mergeSort(arr,0,arr.length-1);  //inputs-array , leftmost index and rightmost index
        System.out.println(Arrays.toString(arr));
    }
}
