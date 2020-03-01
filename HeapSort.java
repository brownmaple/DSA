package generalPrograms;

import java.util.ArrayList;

public class HeapSort {

    public void swap(int arr[], int from, int to){
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to]= temp;
    }

    public void heaper(int arr[],int i, int len) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < len && arr[left] < arr[smallest])
            smallest = left;

        if (right < len && arr[right] < arr[smallest])
            smallest = right;

        if (smallest != i){
            swap(arr, i, smallest);
            heaper(arr,smallest,len); //to heapify the subtree
        }
    }

    public void showArray(int arr[]){
        for (int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        int a[] = {12,11,21,8,9,17,19};
        int length = a.length;
        HeapSort hs = new HeapSort();
        //below for loop is to building a MIN HEAP TREE
        //first loop complexity is nlogn
        for(int i=length/2-1;i>=0;i--){
            hs.heaper(a,i,length);
        }
        //When control reaches this line the tree would be MIN HEAPIFIED
        //Below is to do "I dont know yet"
        //By the end of the previous for loop, the tree would be MIN HEAPIFIED, so the smallest element would be on the top root node aka array[0]
        //since i have chose MIN HEAP, the output will be in descending sorted order. Below for loop makes it happen

        //below for loop is to sort and rebuild the MIN HEAP for the remaining elements
        //second loop complexity is nlogn
        for(int i=a.length-1;i>=0;i--){
            int tem = a[0];
            a[0] = a[i];
            a[i] = tem;
            //when control reaches this line, the smallest element from the top would be moved to the last position
            //below function call will make the tree again MIN HEAPIFIED. ***starting always at the oth node and proceeding upto node i
            hs.heaper(a,0,i);
            //so by the end of each call of this function, second minimum element will reach the top root node or array[0]
        }
        //so total WCC is O(nlogn)
        hs.showArray(a);
    }
}
