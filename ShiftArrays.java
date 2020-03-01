package generalPrograms;

public class ShiftArrays {
    public static void main(String[] args) {
        int[] a = new int[]{3,5,2,6,7};
        int[] b = new int[a.length];
        int n = 3;

        int size = a.length;
        int pos = n-1;

        if(n!=0 || n>=size) {
            for (int i = 0, j = 0; i < size; i++) {
                if (i + pos + 1 < size) { //to check if the next position element is within the array
                    b[i] = a[i + pos + 1];
                } else {
                    b[i] = a[j];
                    j++;
                }
            }


            for (int i = 0; i < b.length; i++) {
                System.out.println(b[i]);
            }
        }
        else{
            System.out.println("No next element to shift");
        }
    }
}
