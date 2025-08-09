import java.util.*;

class Hamiltonian {
    static int[][] G = {
            { 0, 1, 0, 1 },
            { 1, 0, 1, 0 },
            { 0, 1, 0, 1 },
            { 1, 0, 1, 0 }
    };

    static int n = G.length;
    static int[] x = new int[n + 1];

    // Recursive backtracking function to find Hamiltonian cycles
    static void HamiltonianCycle(int k) {

        while (true) {

            NextValue(k);
            if (x[k] == 0) {
                return;
            }
            if (k == n) {
                printSol();
            } else {
                HamiltonianCycle(k + 1);
            }
        }
    }

    // Picks the next vertex for position k
    static void NextValue(int k) {

        while (true) {
            x[k] = (x[k] + 1) % (n + 1);

            if (x[k] == 0) {
                return;
            }
            if (G[x[k - 1] - 1][x[k] - 1] != 0) {
                int j;
                for (j = 1; j < k; j++) {
                    if (x[k] == x[j]) {
                        break;
                    }
                }
                if(j == k) {
                if ( (k < n) || (k == n && G[x[k] - 1][x[1] - 1] != 0) ) {
                    return;
                }
            }
            }
        }

    }

    // Prints one Hamiltonian cycle
    static void printSol() {

        for (int i = 1; i <= n; i++) {
            System.out.print(x[i] + " ");
        }
        System.out.println();

    }

    public static void main(String[] args) {

        for(int i = 1; i <= n; i++) {
            x[i] = 0;
        }
        x[1] = 1;
        HamiltonianCycle(2);
    }
}

//yt link
//https://youtu.be/dQr4wZCiJJ4?si=stbK-KD7l60JxD8k
//https://youtu.be/xyLyBs3ur8Q?si=OgMZAgpROz_k01fH