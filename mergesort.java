class MergeSort {

static int[] a = {6,3,9,1,4,7};
    public static void mergesort(int low,int high) {
        if(low < high) {
            int mid = (low + high)/2;
            mergesort(low, mid);
            mergesort(mid+1, high);
            merge(low, mid, high);
        }
    }

    public static void merge(int low, int mid, int high) {
        int[] b = new int[6];

        int i = low; 
        int j = mid +1;
        int x = low;
        while ( i <= mid && j <= high) {
            if(a[i] <= a[j]) {
                b[x] = a[i];
                x++;
                i++;
            } else {
                b[x] = a[j];
                x++;
                j++;
            }          
        }
        while(i<=mid) {
            b[x] = a[i];
            i++;
            x++;
        }
        while(j<=high) {
            b[x] = a[j];
            j++;
            x++;
        }
        for( int k = low ; k <= high; k++) {
            a[k] = b[k];
        }
    }


    public static void main(String[] args) {
        mergesort(0, a.length - 1);
        System.out.println("Sorted array:");
        for (int num : a) {
            System.out.print(num + " ");
        }
    }
}

//yt link
//https://youtu.be/unxAnJBy12Q?si=Ie0HQn4mFNuJTR7f