import java.util.*;
import java.lang.*;

class ShortestPath{
    public int [] dis;
    public boolean [] vis;
    public int n;

    public int minDist(){
        int _min = Integer.MAX_VALUE;
        int index = -1;

        for(int i=0 ; i<n ; i++) {
            if (_min > dis[i] && !vis[i]) {
                _min = dis[i];
                index = i;
            }
        }
        return index;
    }

    public void init(int n){
        this.dis = new int [n];
        this.vis = new boolean[n];
        this.n = n;

        for(int i=0 ; i<n ; i++){
            this.dis[i] = Integer.MAX_VALUE;
            this.vis[i] = false;
        }
    }

    public void printShortDistances(){
        for(int ele : this.dis)
            System.out.print(ele + "->");

        System.out.println();
    }

    public void dijkstra(int [][] graph, int start){
        init(graph.length);
        this.dis[start] = 0;

        for(int j=0 ; j<n-1 ; j++){

            int u = minDist();
            vis[u] = true;
            for(int k=0 ; k<n ; k++){
                if(graph[u][k] != 0 && !vis[k] && dis[u] + graph[u][k] < dis[k]){
                    dis[k] = dis[u] + graph[u][k];
                }
            }
        }

        printShortDistances();
    }
}

public class DijikstraAlgo {
    public static void main(String [] args) {
        int graph[][]
                = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}};
        ShortestPath t = new ShortestPath();

        // Function call
        t.dijkstra(graph, 0);
    }
}
