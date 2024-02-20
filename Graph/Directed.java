package Graph;
import java.util.*;
public class Directed {
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

    public static boolean isCyclic(ArrayList<Edge>[] graph){
        boolean[] stack=new boolean[graph.length];
        boolean[] visit=new boolean[graph.length];
        
        for(int i=0; i<graph.length; i++){
            if(!visit[i]){
                if(isCyclicUtil(graph, stack, visit, i)){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isCyclicUtil(ArrayList<Edge>[] graph, boolean[] stack, boolean[] visit, int curr){
        visit[curr]=true;
        stack[curr]=true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e=graph[curr].get(i);
            if(stack[e.dest]){
                return true;
            }
            if(!visit[e.dest] && isCyclicUtil(graph, stack, visit, e.dest)){
                return true;
            }
        }
        stack[curr]=false;
        return false;
    }

    public static void topoSort(ArrayList<Edge>[] graph){
        Stack<Integer> s=new Stack<>();
        boolean[] visit=new boolean[graph.length];

        for(int i=0; i<graph.length; i++){
            if(!visit[i]){
                topoSortUtil(graph, i ,visit, s);
            }
        }

        while(!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
    }

    public static void topoSortUtil(ArrayList<Edge>[] graph, int curr, boolean[] visit, Stack<Integer> s){
        visit[curr]=true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e=graph[curr].get(i);
            if(!visit[e.dest]){
                topoSortUtil(graph, e.dest, visit, s);
            }
        }
        s.push(curr);
    }
    public static void main(String[] args) {
        ArrayList<Edge>[] dg=intiGraph(4);
        dg[0].add(new Edge(0, 2, 1));
        dg[1].add(new Edge(1, 0, 1));
        dg[2].add(new Edge(2, 3, 1));
        dg[3].add(new Edge(3, 0, 1));
        System.out.println(isCyclic(dg));

        ArrayList<Edge>[] g=intiGraph(6);
        g[5].add(new Edge(5, 0, 1));
        g[5].add(new Edge(5, 2, 1));

        g[4].add(new Edge(4, 0, 1));
        g[4].add(new Edge(4, 1, 1));

        g[2].add(new Edge(2, 3, 1));
        g[3].add(new Edge(3, 1, 1));

        topoSort(g);
    }
}
