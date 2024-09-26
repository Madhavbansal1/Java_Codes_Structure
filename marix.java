import java.util.Scanner;

public class marix {
    public static void main(String[] args) {
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

        int[][] matrix = new int[v][v];
        creatematrix(matrix,v,edges);
        for(int i=0;i<v; i++){
            for (int j=0; j<v; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void creatematrix(int[][] matrix, int v, int[][] edges){
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int V = edges[i][1];
            matrix[u][V] = 1;
            matrix[V][u] = 1;
        }
    }
}
