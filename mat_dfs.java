public class mat_dfs {
    public static void main(String[] args) {
        int[][] mat = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        dfs(mat,0,0,visited);
    }

    public static void dfs(int[][] mat, int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        System.out.println(mat[i][j]);
        int[] di = {0,1,0,-1};
        int[] dj = {1,0,-1,0};
        for (int r=0; r<4; r++){
            int nbr_x = i+di[r];
            int nbr_y = j+dj[r];
            if(nbr_x >=0 && nbr_x<mat.length && nbr_y >= 0 && nbr_y<mat[0].length && !visited[nbr_x][nbr_y]){
                dfs(mat,nbr_x,nbr_y,visited);
            }
        }

    }
}
