import java.util.*;
class BFS{
    int visited[];
    int adjmatrix[][];
    int vertices=6;

    public BFS(){
        adjmatrix=new int[][]{
             {0, 1, 1, 0, 1, 0},
             {1, 0, 0, 1, 0, 1},
             {1, 0, 0, 1, 0, 1},
             {0, 1, 1, 0, 1, 0},
             {1, 0, 0, 1, 0, 1},
             {0, 1, 1, 0, 1, 0},
        };
        visited= new int[vertices];
    }
    public void bfs(int start){
        Queue<Integer> queue= new LinkedList<>();
        queue.add(start);
        visited[start]=1;
        while(!queue.isEmpty()){
            int u = queue.remove();
            System.out.println("Visited Vertex: "+u);

            for(int v=0;v<vertices;v++){
                if(adjmatrix[u][v]==1 && visited[v]==0){
                    queue.add(v);
                    visited[v]=1;
                }
            }
        }
    }
    public static void main(String[] args) {
        BFS obj =new BFS();
        obj.bfs(0);
    }
}