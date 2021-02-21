import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] graph;
    static boolean[] bfsVisted;
    static boolean[] dfsVisted;
    static Queue<Integer> bfsQueue;

    // 백준 1260 : DFS와 BFS
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // 정점 개수
        int m = sc.nextInt();   // 간선 개수
        int v = sc.nextInt();   // 탐색 시작할 정점의 번호
        graph = new int[n+1][n+1];   // 간선 연결상태 저장
        dfsVisted = new boolean[n+1];
        bfsVisted = new boolean[n+1];
        bfsQueue = new LinkedList<>();

        for (int i = 0; i < dfsVisted.length; i++) {
            dfsVisted[i] = false;
            bfsVisted[i] = false;
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        dfs(v, dfsVisted);
        System.out.println();
        bfs(v);
    }

    public static void dfs(int v, boolean[] dfsVisted){
        System.out.print(v + " ");
        dfsVisted[v] = true;
        for (int i = 1; i < graph.length; i++) {
            if(graph[v][i] == 1 && dfsVisted[i] == false){
                dfs(i, dfsVisted);
            }
        }
    }

    public static void bfs(int v){
        bfsVisted[v] = true;
        bfsQueue.add(v);
        while(!bfsQueue.isEmpty()){
            int poll = bfsQueue.poll();
            System.out.print(poll + " ");
            for (int i = 1; i < graph.length; i++) {
                if(graph[poll][i] == 1 && bfsVisted[i] == false){
                    bfsVisted[i] = true;
                    bfsQueue.add(i);
                }
            }
        }

    }

}
