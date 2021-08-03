
import java.util.ArrayList;
import java.util.LinkedList;

public class graph {
    
    public static class Edge{
        int src; // source
        int nbr; // neighbour (matlab destination)
        int wt; // weight of the edge
        
        Edge(int scr, int nbr, int wt){
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    // ------------------------------------------------------
    public static class ceilFloorPair{
        int ceil = (int)1e9;
        int floor = -(int)1e9;
    }
    
    public static void ceilAndFloor(ArrayList<Edge>[] graph, int src, int data, boolean[] vis, int wsf, ceilFloorPair pair){
        if(wsf > data)
            pair.ceil = Math.min(pair.ceil, wsf);
        if(wsf < data)
            pair.floor = Math.max(pair.floor, wsf);

        // mark
        vis[src] = true;

        //
        for(Edge e : graph[src]){
            if(!vis[e.nbr]){
                ceilAndFloor(graph, e.nbr, data, vis, wsf + e.wt, pair);
            }
        }

        // unmark
        vis[src] = false;
    }

    public static void ceilAndFloor(ArrayList<Edge> graph, int src, int data){
        ceilFloorPair pair = new ceilFloorPair();
        boolean[] vis = new boolean[graph.length];;
        ceilAndFloor(graph, src, data, vis, 0, pair);
    }

    // ------------------------------------------------------
    // O(E)
    public static void dfs_GCC(ArrayList<Edge>[] graph, int src, boolean[] vis, ArrayList<Integer> smallAns){
        vis[src] = true;
        smallAns.add(src);
        for(Edge e: graph[src]){
            if(!vis[e.nbr]){
                dfs_GCC(graph, e.nbr, vis, smallAns);
            }
        }
    }

    // O(E + V)
    public static void GCC(ArrayList<Edge>[] graph, ArrayList<ArrayList<Integer>> comps){
        int N = graph.length, componentCount = 0;
        boolean[] vis = new boolean[N];
        ArrayList<Integer> smallAns = new ArrayList<>();

        for(int i = 0 ; i < N ; i++){
            if(!vis[i]){
                smallAns = new ArrayList<>(); // smallAns.clear(); // karna se arraylist clear hoo rahi thi and  
                dfs_GCC(graph, i, vis, smallAns);
                comps.add(smallAns);
                componentCount++;
            }
        }
        // System.out.println(componentCount);
    }

    // ------------------------------------------------------
    // osrc -> orignal source
    public static hamintonianPathCycle(ArrayList<Edge>[] graph, int osrc, int src, int EdgeCount, boolean[] vis, String ans){
        if(EdgeCount == graph.length - 1){
            int idx = findEdge(graph, src, oscr);
            if(idx != -1){
                System.out.println(ans + src + " ");
            }else{
                Systen.out.println(ans + src + " ");
            }
            return;
        }

        // mark
        vis[src] = true;

        for(Edge e : graph[src]){
            if(!vis[e.nbr]){
                hamintonianPathCycle(graph, osrc, e.nbr, EdgeCount + 1, vis, ans + src);
            }
        }

        // unmark
        vis[src] = false;
    }

    public static void hamintonianPathCycle(ArrayList<Edge>[] graph, int src){
        int N = graph.length;
        hamintonianPathCycle(graph, src, src, 0, vis, "");
    }

    public static void BFS(ArrayList<Edge>[] graph, int src, int dest){
        LinkedList<Integer> que = new LinkedList<>();
        int N = graph.length;
        boolean[] vis = new boolean[N];

        que.addLast(src);
        int level = 0;

        boolean isCyclePresent = false;
        int shortestPath = -1;

        while(que.size() != 0){
            int size = que.size();
            while(size-- > 0){
                int rvtx = que.removeFirst();

                // for cycle
                if(vis[rvtx]){
                    isCyclePresent = true;
                    continue;
                }
                
                if(rvtx == dest){
                    shortestPath = level;
                }

                vis[rvtx] = true;
                for(Edge e : graph[rvtx]){
                    if(!vis[e.nbr]){
                        que.addLast(e.nbr);
                    }
                }
            }
        }
    }

}
