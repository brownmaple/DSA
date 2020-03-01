package generalPrograms;

public class MergeSort {
    public void mergeSort(int[] farray, int l,int r){
        if(l<r) {
            int m = (l+r) / 2;
            mergeSort(farray, l, m);
            mergeSort(farray, m + 1, r);
            merge(farray,l,m,r);
        }
    }
    public void merge(int[] array, int left, int mid, int right){
        //firstly we need to create temp arrays or sub arrays
        //calculate size for the temp arrays
        int a1size = mid-left+1;
        int a2size = right - mid;
        //create temp arrays
        int[] array1 = new int[a1size];
        int[] array2 = new int[a2size];
        //copy the input array contents into temp arrays
        for(int i=0;i<a1size;i++){
         array1[i] = array[left+i];
        }
        for(int i=0;i<a2size;i++){
            array2[i]= array[mid+1+i];
        }
        //compare and merge(rewrite) the contents from temp arrays into input array
        int i=0, j=0; //starting indexes for temp arrays
        int k=left; //starting index of the input (main) array
        while(i<a1size && j<a2size){
            if(array1[i]<array2[j]){
                array[k]=array1[i];
                i++;
            }
            else{
                array[k]=array2[j];
                j++;
            }
            k++;
        }
        //below code to copy the remaining contents (if any) from temp arrays
        while(i<a1size){
            array[k]=array1[i];
            i++;
            k++;
        }
        while(j<a2size){
            array[k]=array2[j];
            j++;
            k++;
        }
    }
    public static void main(String[] args) {
        int[] a = new int[]{12,11,13,5,6,31,24};
       MergeSort ms = new MergeSort();
       ms.mergeSort(a,0,6);
       for (int i=0;i<a.length;i++){
           System.out.print(a[i]+" ");
       }
       }
}
