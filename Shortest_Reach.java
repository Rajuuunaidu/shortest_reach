package week6;


import java.util.*;

public class Shortest_Reach {
    //private static LinkedList<Integer> queue = new LinkedList<Integer>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        for(int i=0; i<test; i++){
            int nodes = in.nextInt();
            int edges = in.nextInt();
            int[] distance = new int[nodes];
            boolean[] visited = new boolean[nodes];
            List<Integer>[] adjacent =  (List<Integer>[]) new ArrayList[nodes];
            for(int k=0; k<nodes; k++){
            	adjacent[k] = new ArrayList<Integer>();
                
            }
            for(int j=0; j<edges; j++){
                int start = in.nextInt()-1;
                int end = in.nextInt()-1;
                adjacent[start].add(end);
                adjacent[end].add(start);
            }
            int start = in.nextInt();
            bfs(adjacent, distance, visited,  start-1);
            for(int l=0; l<nodes; l++){
                if(l != start-1){
                    if(distance[l]>0) System.out.print(distance[l]+" ");
                    else System.out.print("-1"+" ");
                }
            }
            System.out.println();
                 }
        in.close();
    
    }
    
    public static void bfs(List<Integer>[] adj, int[] dist, boolean[] visited_nodes, int s){
       LinkedList<Integer> queue = new LinkedList<Integer>();
        //if(visited[s]) return;
       visited_nodes[s] = true;
        dist[s] = 0;
        queue.offer(s);
        while(!queue.isEmpty()){
            int u = queue.pollFirst();
               for(int w : adj[u]){
                    if(!visited_nodes[w]){
                    
                    dist[w] = dist[u]+6;
                    visited_nodes[w] = true;
                    queue.offer(w);
                    }
                }
                
                       
        }
    }
}

