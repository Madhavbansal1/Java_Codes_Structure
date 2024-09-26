import java.util.*;

public class graph {
    public  static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] edges = new int[n][m];

        for(int i=0;i<n; i++){
            for (int j=0; j<m; j++){
                edges[i][j] = sc.nextInt();
            }
        }

        ArrayList<ArrayList<Integer>> gra = new ArrayList<>();
        createAdjList(gra,v,edges);


        System.out.println(gra);
        bfs_all(gra);
    }

    public static void createAdjList(ArrayList<ArrayList<Integer>>gra, int V,int[][] edges) {
        for(int i=0; i<V; i++){
            gra.add(new ArrayList<>());
        }

        for (int i=0; i<edges.length; i++){
            int u= edges[i][0];
            int v = edges[i][1];

            gra.get(u).add(v);
            gra.get(v).add(u);

        }

    }

    public static void bfs(ArrayList<ArrayList<Integer>>gra,int s,boolean[] visited ) {
        Queue<Integer> q = new LinkedList<>();
        // add source to queue
        q.offer(s);
        visited[s] = true;
        //traverse while q is not empty
        while(!q.isEmpty()){
            int curr = q.poll();
            System.out.println(curr);
            ArrayList<Integer> nbr_list = gra.get(curr);
            for (Integer nbr: nbr_list){
                if(!visited[nbr]) {
                    q.offer(nbr);
                    visited[nbr] = true;
                }
            }
        }
    }

    public static void bfs_all(ArrayList<ArrayList<Integer>>gra) {
        int v = gra.size();
        boolean[] viaited = new boolean[gra.size()];
        for (int i=0; i< gra.size(); i++){
            if(!viaited[i]){
                bfs(gra,i,viaited);
            }
        }

    }


    public static void dfs(ArrayList<ArrayList<Integer>> gra, int s, boolean[] visited) {

        visited[s] = true;
        System.out.println(s);
        ArrayList<Integer> nbr = gra.get(s);
        for(Integer i:nbr){
            if(!visited[i]){
                visited[i] = true;
                dfs(gra,i,visited);
            }
        }

    }

    public static void dfs_all(ArrayList<ArrayList<Integer>> gra) {
        int v = gra.size();
        boolean[] visited = new boolean[gra.size()];
        for (int i=0; i< gra.size(); i++) {
            if (!visited[i]) {
                dfs(gra, i, visited);
            }
        }



    }
}
