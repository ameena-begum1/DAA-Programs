import java.util.Scanner;

class Mergesort {

    public static void merge(int[] A, int low, int mid, int high) {

        int i = low;
        int j = mid + 1;
        int k = low;
        int[] B = new int[high + 1];

        while (i <= mid && j <= high) {
            if (A[i] < A[j]) {
                B[k] = A[i];
                i++;
            } else {
                B[k] = A[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {

            B[k] = A[i];
            i++;
            k++;

        }

        while (j <= high) {
            B[k] = A[j];
            j++;
            k++;
        }

        for (int x = low; x <= high; x++) {
            A[x] = B[x];
        }

    }

    public void mergesort(int[] A, int low, int high) {

        if (low < high) {

            int mid = (low + high) / 2;
            mergesort(A, low, mid);
            mergesort(A, mid + 1, high);
            merge(A, low, mid, high);
        }

    }

    public static void main(String[] args) {

        Mergesort obj = new Mergesort();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size:");
        int n = sc.nextInt();
        int[] A = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        System.out.println("Original array:");
        for (int i = 0; i < n; i++) {
            System.out.print(A[i] + " ");
        }

        System.out.println();
        
        obj.mergesort(A, 0, n - 1);

        System.out.println("Sorted array");
        for (int i = 0; i < n; i++) {
            System.out.print(A[i] + " ");
        }

    }
}

//yt link
//https://youtu.be/unxAnJBy12Q?si=Ie0HQn4mFNuJTR7f

