/* N-Queen’s problem solution using Backtracking approach. */

import java.util.*;

class nqueens {

    static int[] x = new int[100];
    static int count = 0;

    //check for the cell is safe or not
    public static boolean isSafe(int row, int col) {
        for (int j = 1; j <= row - 1; j++) {
            if ((x[j] == col) || (Math.abs(x[j] - col) == Math.abs(j - row))) {
                return false;
            }
        }
        return true;
    }

    //function to print the output solution 
    public static void printBoard(int n) {
        count++;
        System.out.println("\nSolution " + count + ":");

        System.out.print("   ");
        for (int col = 1; col <= n; col++) {
            System.out.print(col + " ");
        }
        System.out.println();
        
        
        for (int row = 1; row <= n; row++) {
            System.out.print(row + "  "); 
            for (int col = 1; col <= n; col++) {
                if (x[row] == col) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    // Recursive function to place queens row by row 
    public static void NQueens(int row, int n) {
        int col = 1;
        for (col = 1; col <= n; col++) {
            if (isSafe(row, col)) {
                x[row] = col;
                if (row == n)
                printBoard(n);
                 else {
                    NQueens(row + 1, n);
                }
            }
        }
    }

    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of queens (n): ");
        int n = sc.nextInt();

        NQueens(1, n); 

        System.out.println("\nTotal number of solutions for " + n + " queens: " + count);
    }
}


//yt link
//https://youtu.be/BdSJnIdR-4s?si=VxfgdWP9lc1JBxrg