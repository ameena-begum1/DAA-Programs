import java.util.*;
class krushkals{
    
    public static void main(String[]args){
        int n=4;
        int edges[][]={
            {0,1,10},{0,2,4},{1,2,12},{1,3,15},{2,3,14}
        };
        int e=edges.length;
        Arrays.sort(edges,Comparator.comparingInt(a->a[2]));
        int mincost=0,count=0;
        parent=new int[n];
        Arrays.fill(parent,-1);
        int mst[][]=new int[n-1][3];
        for(int i=0;i<e&&count<n-1;i++){
            int u=edges[i][0];
            int v= edges[i][1];
            int w=edges[i][2];
            int uroot=find(u);
            int vroot=find(v);
            if(uroot!=vroot){
                mst[count][0]=u;
                mst[count][1]=v;
                mst[count][2]=w;
                count++;
                mincost+=w;
                union(uroot,vroot);
            }
        }
        if(count!=n-1)
        System.out.println("No spanning tree");
        else
        {
            System.out.println("Spanning tree edges");
            for(int i=0;i<count;i++){
                System.out.println(mst[i][0] +"-"+mst[i][1]);
            }
            System.out.println();
        }
        System.out.println("MIN COST: "+mincost);
    }
    static int parent[];
    static int find(int i){
        if(parent[i]==-1)
        return  i;
        return parent[i]=find(parent[i]);
    }
    static void union(int x,int y){
        int xset=find(x);
        int yset=find(y);
        if(xset!=yset){
            parent[xset]=yset;
        }
    }
}