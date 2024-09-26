import java.util.LinkedList;
import java.util.Queue;

public class mat_bfs {
    public static void main(String[] args) {
        int[][] mat = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

        bfs(mat,0,0);
    }

    public static void bfs(int[][] mat,int i, int j){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        q.offer(new int[]{i,j});
        visited[i][j] = true;
        
        while (!q.isEmpty()){
            int[] n = q.poll();
            int curr_x = n[0];
            int cuur_y = n[1];
            System.out.println(curr_x + " "+ cuur_y);
            int[] di = {0,1,0,-1};
            int[] dj = {1,0,-1,0};
            for (int r=0; r<4; r++){
                int nbr_x = curr_x+di[r];
                int nbr_y = cuur_y+dj[r];
                if(nbr_x >=0 && nbr_x<mat.length && nbr_y >= 0 && nbr_y<mat[0].length && !visited[nbr_x][nbr_y]){
                    q.offer(new int[]{nbr_x,nbr_y});
                    visited[nbr_x][nbr_y] = true;
                }
            }
        }
    }
}
