import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;

public class Graph {
    
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
    

    // add edge for bi-directional graph
    public static void addEdge(ArrayList<Edge>[] graph, int u, int v, int w){

        graph[u].add(new Edge(u, v, w)); // ik edge add hoor raha hai (u se v tak)
        graph[v].add(new Edge(v, u, w)); // ik aur edge add hoor raha hai (v se u tak) BI-DIRECTED GRAPH KA LIA
    }
    
    // ---------------------------------------------------
    public static void display(ArrayList<Edge>[] graph, int N){
        for(int i= 0 ; i < N ; i++ ){
            System.out.print(i + " -> "); // i -> u 
            for(Edge e : graph[i]){
                System.out.print("(" + e.nbr + ", " + e.wt + ") " );
            }
            System.out.println();
        }
    }


    // ---------------------------------------------------
    public static int findEdge(ArrayList<Edge>[] graph, int u, int v){
        ArrayList<Edge> list = graph[u];
        for( int i = 0 ; i < list.size() ; i++ ){
            Edge e = list.get(i);
            if(e.nbr == v)
                return i;
        } 

        return -1;
    }

    public static void removeEdge(ArrayList<Edge>[] graph, int u, int v){
        // i1, i2 -> are the indexes of the array jaha par u mia v & v mai u mila hoga (and humna use remove karna hai, edge ko remove karna ka lia)
        int i1 = findEdge(graph, u, v); // u ka anadar v dhund loo
        int i2 = findEdge(graph, u, v); // v ka andar u dhund loo

        graph[u].remove(i1); // removing v edge (which is at index i1 of arraylist) from u (array)
        graph[v].remove(i2);
    }


    // ---------------------------------------------------
    public static void removeVtx(ArrayList<Edge>[] graph, int u){
        ArrayList<Edge> list = graph[u];
        // last se traverse kar raha hai ( shifting valichiz se bachna kaa lia) 
        for(int i = list.size() - 1 ; i >= 0 ; i-- ){
            Edge e = list.get(i);
            removeEdge(graph, e.src, e.nbr);
        }
    }

    // ----------------------------------------------------
    // it is like fooldfill in recursion
    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis){
        if(src == dest)
            return true;
        
        // mark  (unmark karna ki jarurat naih kio ki humna sara route explore nahi karna src se dest tak kaa)
        vis[src] = true;
        boolean res = false;
        for(Edge e : graph[src])
            if(!vis[e.nbr])
                res = res || hasPath(graph, e.nbr, dest, vis);

        return res;
    }

    
    // ================================================
    // 29 June class-2 (tue)
    // ================================================
    
    // -----------------------------------------------
    // psf -> path soo far, 
    public static int printAllPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis, String psf){
        if(src == dest){
            System.out.println(psf + dest);
            return 1;
        }
    
        int count = 0;
    
        // mark
        vis[src] = true;
    
        // do the work here that you want to do
        for(Edge e : graph[src]){
            if(!vis[e.nbr])
                count += printAllPath(graph, e.nbr, dest, vis, psf + src);
        }
    
        // unmark
        vis[src] = false;
    
        return count;
    }
    
    // -----------------------------------------------
    // wsf -> weight soo far, psf -> path soo far
    public static void preOrder(ArrayList<Edge>[] graph, int src, boolean[] vis, int wsf, String psf){
        System.out.println(src + " -> " + (psf + src)+ " @ " + wsf);
        
        // mark
        vis[src] = true;
    
        for(Edge e : graph[src]){
            if(!vis[e.nbr]) // unvisited neighbour
                preOrder(graph, e.nbr, vis, wsf + e.wt, psf + src);
        }
    
        // unmark
        vis[src] = false;
    }
    
    // -----------------------------------------------
    public static void postOrder(ArrayList<Edge>[] graph, int src, boolean[] vis, int wsf, String psf){

        // mark
        vis[src] = true;
    
        for(Edge e : graph[src]){
            if(!vis[e.nbr])
                postOrder(graph, e.nbr, vis, wsf + e.wt, psf + src);
        }
    
        // unmark
        vis[src] = false;

        System.out.println(src + " -> " + (psf + src) + " @ " + wsf);
    }
    
    // -----------------------------------------------------
    // public static class pathPair{
    //     String psf = "";
    //     int wsf = 0;
    // }

    // public static pathPair lighestPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis){
    //     if(src == dest){
    //         pathPair base = new pathPair();
    //         base.psf += src;
    //         base.wsf = 0;

    //         return base;
    //     }

    //     // mark
    //     vis[src] = true;

    //     pathPair myAns = new pathPair();
    //     for(Edge e : graph[src]){
    //         if(!vis[e.nbr]){
    //             // pathPair recAns = ligest
    //         }
    //     }
    // }
    // public static void lightestPath(ArrayList<Edge>[] graph, int src, int dest, int[] vis){
    //     boolean[] vis = new boolean[graph.length];
    //     pathPair ans = lightestPath(graph, src, dest, vis);
    //     // System.out.println("Lightest Path: " + x + " of weight: " + y);
        
    //     System.out.println("Lighest Path: " + ans.psf + " of weight: " + ans.wsf);
    // }
    
    // -----------------------------------------------------
    // public static void heaviestPath(ArrayList<Edge>[] graph, int src, int dest){
    
    //     // System.out.println("Heaviest Path: " + x + " of weight: " + y);
    
       

    // ================================================
    // 6 July, class-4 (tue)
    // ================================================


    // ----------------------------------------------
    public static boolean cycleDetection(ArrayList<Edge>[] graph, int src, boolean[] vis){
        LinkedList<Integer> que = new LinkedList<>;
        que.addLast(src);

        while(que.size() != 0){
            int size = que.size();
            while(size-- > 0){
                Integer rvtx = que.removeFirst();
                if(vis[rvtx])
                    return true;

                vis[rvtx] = true;
                for(Edge e : graph[rvtx]){
                    if(!vis[e.nbr])
                        que.addLast(e.nbr);
                }
            }
        }
        return false;
    }

    public static void cycleDetection(ArrayList<Edge>[] graph){
        int vtces = graph.length;
        boolean[] vis = new boolean[vtces];
        boolean res = false;
        for(int i = 0 ; i < vtces ; i++){
            if(!vis[i])
                res = res || cycleDetection(graph, i, vis);
        }

        System.out.print(res);
    }


    // ----------------------------------------------
    public static class BFS_Pair{
        int vtx = 0; // jaha jaa raha hai, jiss vertex pai
        String psf = "";
        int wsf = 0;

        public BFS_Pair(int vtx, String psf, int wsf){
            this.vtx = vtx;
            this.psf = psf;
            this.wsf = wsf;
        }
    }
    
    public static void printBFSPath(ArrayList<Edge>[] graph, int src){
        int vtces = graph.length;
        boolean[] vis = new boolean[vtces];

        LinkedList<BFS_Pair> que = new LinkedList<>();
        que.addLast(new BFS_Pair(src, src + "", 0));

        while(que.size() != 0){
            int size = que.size();
            while(size-- > 0){
                BFS_Pair rp = que.removeFirst(); // rp -> remove pair
                if(vis[rp.vtx])
                    continue;

                System.out.println(rp.vtx + " -> " + rp.psf + " @ " + rp.wsf);

                vis[rp.vtx] = true;

                for(Edge e : graph[rp.vtx]){
                    if(!vis[e.nbr])
                        que.addLast(new BFS_Pair(e.nbr, rp.psf + e.nbr, rp.wsf + e.wt));
                }
            }
        }
    }

    // --------------------------------------------------
    public static int spreadInfection(ArrayList<Edge>[] graph, int infectedPerson, int NoOfDays){
        LinkedList<Integer> que = new LinkedList<>();
        boolean[] vis = new boolean[graph.length];

        que.addLast(infectedPerson);

        int infectedCount = 0, day = 1;
        while(que.size() != 0){
            int size = que.size();

            if(day > NoOfDays){
                break;
            }

            while(size-- > 0){
                int ip = que.removeFirst(); // infectedPerson
                if(vis[ip])
                    continue;

                vis[ip] = true;
                infectedCount++;

                for(Edge e : graph[ip]){
                    if(!vis[e.nbr])
                        que.addLast(e.nbr);
                }
            }
            day++;
        }
        return infectedCount;
    }


    // ---------------------------------------------------
    public static void bipartite(ArrayList<Edge>[] graph, int src, int[] vis){
        
    }

    public static void bipartite(ArrayList<Edge>[] graph){
        int N = graph.length;
        int[] vis = new int[N];
        Arrays.fill(vis, -1);
    }


    public static void construction(){
        int N = 7; // Number of vertices
        // array of Type ArrayList
        ArrayList<Edge>[] graph = new ArrayList[N]; // yaa ik array hai joo arraylist of edge koo store karna janta hai (store kara thori hai abhi tak, store karna kaa lia nicha ik for loop mai arraylist store kara raha hai array mai)

        // har index of array pai ik empty ArrayList create ki
        for(int i = 0 ; i < N ; i++)
            graph[i] = new ArrayList<>();


        addEdge(graph, 0, 1, 10);
        addEdge(graph, 0, 3, 10);
        addEdge(graph, 1, 2, 10);
        addEdge(graph, 2, 3, 40);
        addEdge(graph, 3, 4, 2);
        addEdge(graph, 4, 5, 2);
        addEdge(graph, 4, 6, 8);
        addEdge(graph, 5, 6, 3);

        // display(graph, N);

        boolean[] vis = new boolean[N];
        // System.out.println(printAllPath(graph, 0, 6, vis, ""));
        // System.out.println(printAllPath(graph, 0, 0, vis, "")); // src & dest dono same hai, tho print hoga 0
        // System.out.println(printAllPath(graph, 0, 4, vis, ""));

        // ----------------------------
        // preOrder(graph, 0, vis, 0, ""); 

        //------------------------------
        postOrder(graph, 0, vis, 0, "");

    }

    public static void main(String[] args){
        construction(); // construction of the graph
        
    }
}


// javac Graph.java && java Graph > output.txt