import java.util.*;
public class DFS_BFS {
    static Scanner sc = new Scanner(System.in);
    static class Edge {
        int src;
        int dest;
        Edge(int s, int d) {
            src = s;
            dest = d;
        }
    }
    public static void printGraph(ArrayList<Edge>[] g) {
        System.out.println("Length "+g.length);
        System.out.println("\nGraph : \nStart      Destination");
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[i].size(); j++) {
                Edge curr = g[i].get(j);
                System.out.println("  "+curr.src+"------------>"+curr.dest);
            }
        }
    }
    public static void BFS(ArrayList<Edge>[] g, boolean[] visited, int index, Queue<Integer> q) {
        if(q.isEmpty() || index == g.length) {
            return;
        }
        Edge curr = g[index].get(0);
        if(visited[index] == false) {
            System.out.println(curr.src);
            visited[index] = true;
            for (int i = 0; i < g[index].size(); i++) {
                q.add(curr.dest);
            }
        }
        BFS(g, visited, index+1, q);

    }
    public static void DFS(ArrayList<Edge>[] g,  boolean[] visited, int index, Stack<Integer> s) {
        if(s.isEmpty() || index == g.length) {
            return;
        }
        Edge curr = g[index].get(0);
        if(visited[index] == false) {
            System.out.println(curr.src);
            visited[index] = true;
            for (int i = 0; i < g[index].size(); i++) {
                int newIndex = index+1;
                int newNode = g[index].get(i).dest;
                for (int j = 0; j < g.length; j++) {
                    for (int k = 0; k < g[j].size(); k++) {
                        if(g[j].get(k).src == newNode) {
                            newIndex = j;
                            break;
                        }
                    }
                }
                DFS(g, visited, newIndex, s);
            }
        }
    }
    public static void main(String[] args) {
        System.out.println();
        System.out.print("Enter the No. of vertices Graph has : ");
        int n = sc.nextInt();
        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < graph.length; i++) {
            System.out.print("\nEnter the no. of neighbours "+i+" has : ");
            int m = sc.nextInt();
            System.out.println("Enter all the neighbour vertex "+i+" has : ");
            for (int j = 0; j < m; j++) {
                int d = sc.nextInt();
                graph[i].add(new Edge(i, d));
            }
        }
        printGraph(graph);
        System.out.println();
        System.out.println("BFS Traversal : ");
        boolean visited[] = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(graph[0].get(0).src);
        BFS(graph, visited, 0, q);
        System.out.println();
        System.out.println("DFS Traversal : ");
        visited = new boolean[n];
        Stack<Integer> s = new Stack<>();
        s.push(graph[0].get(0).src);
        DFS(graph, visited, 0, s);
    }
}