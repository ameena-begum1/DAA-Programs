import java.util.Scanner;

class Quicksort {

    public static int partition(int[] A, int low, int high) {

        int pivot = A[low];
        int i = low;
        int j = high + 1;

        do {
            do {
                i++;
            } while (i <= high && A[i] <= pivot);

            do {
                j--;
            } while (A[j] > pivot);

            if (i < j) {
                swap(A, i, j);
            }
        } while (i < j);

        swap(A, low, j);

        return j;
    }

    public void QuickSort(int[] A, int low, int high) {

        if (low < high) {
            int pi = partition(A, low, high);
            QuickSort(A, low, pi - 1);
            QuickSort(A, pi + 1, high);
        }

    }

    public static void swap(int[] A, int i, int j) {
        int temp;
        temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        
        Quicksort obj = new Quicksort();
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

        obj.QuickSort(A, 0, n - 1);

        System.out.println();

        System.out.println("Sorted array:");
        for (int i = 0; i < n; i++) {
            System.out.print(A[i] + " ");
        }
    }
}

//yt link
//https://youtu.be/8MNB0Mba_Dc?si=tquYRICOr7ecuUvJ
//https://youtu.be/QXum8HQd_l4?si=hmJp2x6_fmF3VUkF

