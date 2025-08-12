class Prims {
    public int n;
    public int cost[][];
    int mincost = Integer.MAX_VALUE;
    int k = -1, l = -1;
    int t[][];
    int near[];
    final int INF = Integer.MAX_VALUE; // Constant for infinity

    public Prims() {
        n = 7;
        cost = new int[][] {
            {INF, 28, INF, INF, INF, 10, INF},
            {28, INF, 16, INF, INF, INF, 14},
            {INF, 16, INF, 12, INF, INF, INF},
            {INF, INF, 12, INF, 22, INF, 18},
            {INF, INF, INF, 22, INF, 25, 24},
            {10, INF, INF, INF, 25, INF, INF},
            {INF, 14, INF, 18, 24, INF, INF}
        };
        k = -1;
        l = -1;
        t = new int[n][2];
        near = new int[n];
        for (int i = 0; i < n; i++)
            near[i] = -1;
    }

    public void primsMST() {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (cost[i][j] < mincost) {
                    mincost = cost[i][j];
                    k = i;
                    l = j;
                }
        mincost = cost[k][l];
        t[l][0] = k;
        t[k][1] = l;
        for (int i = 0; i < n; i++)
            if (cost[i][l] < cost[i][k])
                near[i] = l;
            else
                near[i] = k;
        near[k] = -1;
        near[l] = -1;
        for (int i = 1; i < n - 1; i++) {
            int j = nearMin();
            t[i][0] = j;
            t[i][1] = near[j];
            mincost = mincost + cost[j][near[j]];
            near[j] = -1;
            for (int k = 0; k < n; k++)
                if (near[k] != -1 && cost[k][near[k]] > cost[k][j])
                    near[k] = j;
        }
        System.out.println("Edges:");
        for (int i = 0; i < n - 1; i++)
            System.out.println(t[i][0] + " " + t[i][1]);
        System.out.println("Min Cost: " + mincost);
    }

    public int nearMin() {
        int jmin = INF;
        int jvalue = -1;
        for (int i = 0; i < n; i++) {
            if (near[i] != -1 && cost[i][near[i]] < jmin) {
                jmin = cost[i][near[i]];
                jvalue = i;
            }
        }
        return jvalue;
    }

    public static void main(String[] args) {
        Prims pmst = new Prims();
        pmst.primsMST();
    }
}
