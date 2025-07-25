 class DFS {
    static int visited[];
    int adjmatrix[][];
    static int vertices=6; 
    public DFS(){
        adjmatrix= new int[][]{
            {0, 1, 1, 0, 1, 0},
            {1, 0, 0, 1, 0, 1},
             {1, 0, 0, 1, 0, 1},
             {0, 1, 1, 0, 1, 0},
             {1, 0, 0, 1, 0, 1},
             {0, 1, 1, 0, 1, 0},
        };
        visited= new int[vertices];
    }
    public void dfs(int u){
        visited[u]=1;
        System.out.println("Visited vertex: "+u);

        for(int v=0;v< vertices;v++){
            if(adjmatrix[u][v]==1 && visited[v]==0){
                dfs(v);
            }
        }
    }
    public static void main(String[] args) {
        DFS obj = new DFS();
        obj.dfs(0);

        int connected=1;
        for (int i=0;i<vertices;i++){ 
            if(visited[i]==0){
                connected=0;
                break;
            }
        }
        if(connected ==1){
            System.out.println("The Graph is connected");
        }
        else{
            System.out.println("The graph is not connected");
        }
    }
    
}