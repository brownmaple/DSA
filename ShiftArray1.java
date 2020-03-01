package generalPrograms;

public class ShiftArray1 {
    public static void main(String[] args) {
        int[] a = new int[]{3,5,2,6,7};
        int n = 3;
        int npos = n-1;
        int size = a.length;
        int midway = size/2;
        int temp = a[npos];
        a[0] = temp;
        System.out.println(midway);
    }
}
