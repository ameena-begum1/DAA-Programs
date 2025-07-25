class QuickSort {
     static int[] arr = {1,8,2,6,4,6};

    public static void quicksort(int[] arr, int low, int high) {
        if(low< high) {
            int p_ind = partition(arr,low,high);
            quicksort(arr, low, p_ind -1);
            quicksort(arr, p_ind + 1,high);
        }
    }

    public static int partition(int[] arr,int low,int high) {
        int pivot = arr[low];
        int i = low;
        int j = high +1;

        do {
            do {
                i++;
            } while(i<=high && arr[i]<=pivot);
            do {
                j--;
            } while(arr[j] > pivot);
            
            if(i<j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        } while (i<j);

        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
        return j;

    }
    public static void main(String[] args) {
        quicksort(arr, 0, arr.length - 1);
                System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

    }
}

//yt link
//https://youtu.be/8MNB0Mba_Dc?si=tquYRICOr7ecuUvJ
//https://youtu.be/QXum8HQd_l4?si=hmJp2x6_fmF3VUkF