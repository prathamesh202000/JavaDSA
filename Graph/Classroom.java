package Graph;
import java.util.*;
public class Classroom {
    
    public static class Edge{
        int src;
        int dest;
        int wt;

        Edge(int src, int dest, int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
    }

    public static ArrayList<Edge>[] intiGraph(int n){
        ArrayList<Edge>[] graph=new ArrayList[n];

        for(int i=0; i<graph.length; i++){
            graph[i]=new ArrayList<Edge>();
        }

        return graph;
    }

    public static void bfs(ArrayList<Edge>[] graph){
        boolean[] visit=new boolean[graph.length];

        for(int i=0; i<graph.length; i++){
            if(!visit[i]){
                bfsUtil(graph, visit, i);
            }
        }
        System.out.println();
    }

    public static void bfsUtil(ArrayList<Edge>[] graph, boolean[] visit, int i){
        Queue<Integer> q=new LinkedList<>();
        q.add(i);

        while(!q.isEmpty()){
            int curr=q.remove();
            if(!visit[curr]){
                visit[curr]=true;
            System.out.print(curr+" ");
            for(int j=0; j<graph[curr].size(); j++){
                Edge e=graph[curr].get(j);
               
                    q.add(e.dest);
                
            }
        }
        }

        
    }

    public static void dfs(ArrayList<Edge>[] graph){
        boolean[] visit=new boolean[graph.length];

        for(int i=0; i<graph.length; i++){
            if(!visit[i]){
                dfsUtil(graph, visit, i);
            }
        }
        System.out.println();
    }

    public static void dfsUtil(ArrayList<Edge>[] graph, boolean[] visit, int i){
        visit[i]=true;
        System.out.print(i+" ");

        for(int j=0; j<graph[i].size(); j++){
            Edge e=graph[i].get(j);
            if(!visit[e.dest]){
                dfsUtil(graph, visit, e.dest);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visit){
        if(src==dest){
            return true;
        }

        visit[src]=true;

        for(int i=0; i<graph[src].size(); i++){
            Edge e=graph[src].get(i);
            if(!visit[e.dest] && hasPath(graph, e.dest, dest, visit)){
                return true;
            }
        }

        return false;

    }
    public static void main(String[] args) {
    ArrayList<Edge>[] g1=intiGraph(5);

    g1[0].add(new Edge(0, 1, 5));
    g1[1].add(new Edge(1, 2, 1));
    g1[1].add(new Edge(1, 3, 3));
    g1[1].add(new Edge(1, 0, 5));
    g1[2].add(new Edge(2, 1, 1));
    g1[2].add(new Edge(2, 3, 1));
    g1[2].add(new Edge(2, 4, 2));
    g1[3].add(new Edge(3, 1, 3));
    g1[3].add(new Edge(3, 2, 1));
    g1[4].add(new Edge(4, 2, 2));
   

    

    bfs(g1);
    dfs(g1);
    ArrayList<Edge>[] g2=intiGraph(7);
    g2[0].add(new Edge(0, 1, 1));
    g2[0].add(new Edge(0, 2, 1));

    g2[1].add(new Edge(1, 0, 1));
    g2[1].add(new Edge(1, 3, 1));

    g2[2].add(new Edge(2, 0, 1));
    g2[2].add(new Edge(2, 4, 1));

    g2[3].add(new Edge(3, 1, 1));
    g2[3].add(new Edge(3, 4, 1));
    g2[3].add(new Edge(3, 5, 1));

    g2[4].add(new Edge(4, 2, 1));
    g2[4].add(new Edge(4, 3, 1));
    g2[4].add(new Edge(4, 5, 1));

    g2[5].add(new Edge(5, 3, 1));
    g2[5].add(new Edge(5, 4, 1));
    g2[5].add(new Edge(5, 6, 1));

    g2[6].add(new Edge(6, 5, 1));
    
    System.out.println(hasPath(g2, 0, 5, new boolean[g2.length]));

}
}
