package generalPrograms;

public class InsertionSort {
    public void rearrange(int a[]){

        int n = a.length;
        for (int i=1;i<n;i++){
            if(a[i-1]>a[i]){
                int temp = a[i];
                for(int j = i-1;j>=0;j--){
                   if(a[j]>temp) {
                       a[j + 1] = a[j];
                       a[j] = temp;
                   }
                }
            }
        }

        displayArray(a);
    }

    public void displayArray(int a[]){
        for (int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[5];
        a = new int[]{12,11,13,5,6,31,24};
        InsertionSort iso = new InsertionSort();
        iso.rearrange(a);
    }
}
