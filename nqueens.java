import java.util.Scanner;

class NQueens {

    static int n;
    static int[] x;
    static int count = 0;

    public boolean Place(int k, int i) {
        for (int j = 1; j <= k - 1; j++) {
            if (x[j] == i || (Math.abs(x[j] - i) == Math.abs(j - k))) {
                return false;
            }
        }
        return true;
    }

    public void nQueens(int k, int n) {

        for (int i = 1; i <= n; i++) {
            if (Place(k, i)) {
                x[k] = i;
                if (k == n) {
                    printBoard(n);
                } else {
                    nQueens(k + 1, n);
                }
            }
        }
    }

    public void printBoard(int n) {
        count++;
        System.out.println("Solution: " + count);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (x[i] == j) {
                    System.out.print(" Q" + i);
                } else {
                    System.out.print(" X ");
                }
            }
            System.out.println();
        }
        System.out.println();

    }

    public static void main(String[] args) {
        NQueens obj = new NQueens();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of queens:");
        n = sc.nextInt();
        x = new int[n + 1];
        obj.nQueens(1, n);

        System.out.println("Total no. of solutions for the " + n + " queens problem is: " + count);

    }
}


//yt link
//https://youtu.be/BdSJnIdR-4s?si=VxfgdWP9lc1JBxrg
