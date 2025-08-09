import java.util.*;

class GraphColoring {

    static int[][] G = {
            { 0, 1, 1, 1 },
            { 1, 0, 1, 0 },
            { 1, 1, 0, 1 },
            { 1, 0, 1, 0 }
    };
    static int n = G.length;
    static int m = 3;
    static int[] x = new int[n + 1];

    // Try to assign a valid color to vertex k, and recursively color the rest of the graph
    public static void mColoring(int k) {

        while (true) {
            NextValue(k);
            if (x[k] == 0) {
                return;
            }

            if (k == n) {
                printSol();
            } else {
                mColoring(k + 1);
            }
        }
    }

    // apply which color is valid. If no color, then 0 will be assign
    public static void NextValue(int k) {

        while (true) {
            x[k] = (x[k] + 1) % (m + 1);
            if (x[k] == 0) {
                return;
            }
            int j;
            for (j = 1; j <= n; j++) {
                if (G[k - 1][j - 1] != 0 && (x[k] == x[j])) {
                    break;
                }
            }

            if (j == n + 1) {
                return;
            }
        }
    }

    // Print one valid coloring solution for the graph
    static void printSol() {

        for (int i = 1; i <= n; i++) {
            System.out.print(x[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        for (int i = 1; i <= n; i++) {
            x[i] = 0;
        }
        mColoring(1);
    }
}

//yt link
//https://youtu.be/052VkKhIaQ4?si=GnqjhFRrsN8279yc
