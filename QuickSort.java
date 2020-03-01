package generalPrograms;

public class QuickSort {
    public void sort(int[] arr, int start, int end){
        if(start< end) {
            //newPivot is nothing but the new index of the element pointed by the end index
            int newPivot = partition(arr, start, end);
            sort(arr, start, newPivot - 1);
            sort(arr, newPivot + 1, arr.length - 1);
        }
    }

    public int partition(int[] arr, int start, int pivot){
        int j = start;
            for (int i = start; i < pivot; i++) {
                if (arr[i] < arr[pivot]) { //we can use < or <= in this condition. if < is used we will get equal numbers in different sets for sorting.
                                           //if not both numbers will come under a single set
                    swap(arr, i, j);
                    j++;
                }
            }
            swap(arr, j, pivot);
        return j;
    }

    public void swap(int[] arr,int from, int to){
        int temp = arr[from];
        arr[from]=arr[to];
        arr[to]=temp;
    }

    public static void main(String[] args) {
        int[] arr = {8,7,6,1,0,9,2,19,3,2};
        QuickSort qs =new QuickSort();
        qs.sort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }
    }
}
