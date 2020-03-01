package generalPrograms;

public class SelectionSort {

    public void selectAndSort(int a[]){
        int n = a.length;
        for(int i=0;i<n-1;i++){
            int mi = i;
            for(int j=i+1;j<n;j++){
               if(a[j]<a[mi]) {
                   mi=j;
               }
            }
            int temp = a[i];
            a[i] = a[mi];
            a[mi] = temp;
        }
        displayArray(a);
    }

    public void displayArray(int a[]){
        for (int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }

    public static void main(String[] args) {
        int[] a;
        a = new int[]{12,11,13,5,6,31,24};
        //new SelectionSort().selectAndSort(a);
        System.out.println((int)Math.ceil(Math.log(8 + 1) / Math.log(2)) - 1);
    }
}
