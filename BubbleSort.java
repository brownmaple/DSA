package generalPrograms;

public class BubbleSort {
    public void pass(int[] arr){
        int n= arr.length;

        for(int i=0;i<n;i++) {
            for (int j = 0; j < n-i-1 ; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        printArray(arr);
    }

    public void printArray(int[] arr){
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        BubbleSort bs = new BubbleSort();
        int a[] = {1,6,3,16,21,4};
        bs.pass(a);
    }
}
