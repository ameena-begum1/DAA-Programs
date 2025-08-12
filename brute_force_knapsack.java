import java.util.*;

class BruteForceKnapsack {

    public void bruteforce(int wt[], int val[], int M, int n) {

        int[] A = new int[n + 1];
        int[] B = new int[n + 1];
        int bestval = 0;
        int bestwt = 0;

        int totalSubsets = 1 << n;

        for (int i = 0; i < totalSubsets; i++) {
            int j = n;
            while (j > 0 && A[j] == 1) {
                A[j] = 0;
                j--;
            }
            if (j > 0) {
                A[j] = 1;
            }

            int tempval = 0;
            int tempwt = 0;

            for (int k = 1; k <= n; k++) {
                if (A[k] == 1) {
                    tempval += val[k];
                    tempwt += wt[k];
                }
            }

            if (tempwt <= M && tempval > bestval) {
                bestval = tempval;
                bestwt = tempwt;
                B = A.clone();
            }

        }
        System.out.println("Maximum Profit: " + bestval);
        System.out.println("Weight: " + bestwt);
        System.out.print("Items included: ");
        for (int i = 1; i <= n; i++) {
            if (B[i] == 1) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("KnapSack Using Brute Force Approach");

        System.out.println("Enter no. of items");
        int n = sc.nextInt();

        int[] wt = new int[n + 1];
        int[] val = new int[n + 1];

        System.out.println("Enter the weights of each item");
        for (int i = 1; i <= n; i++) {
            wt[i] = sc.nextInt();
        }

        System.out.println("Enter the values of each item");
        for (int i = 1; i <= n; i++) {
            val[i] = sc.nextInt();
        }

        System.out.println("Enter the capacity of the Knapsack");
        int M = sc.nextInt();

        BruteForceKnapsack obj = new BruteForceKnapsack();
        obj.bruteforce(wt, val, M, n);

    }

}


// yt link
// https://youtu.be/cecDyimvQdA?si=AHEN_UGc4R66VqIX