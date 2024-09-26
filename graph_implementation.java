import java.util.HashSet;

public class graph_implementation {
    public static void main(String[] args) {
        Graph1 g = new Graph1(7);
        g.addedege(1,4,6);
        g.addedege(1,2,10);
        g.addedege(2,3,7);
        g.addedege(3,4,5);
        g.addedege(4,5,1);
        g.addedege(5,6,4);
        g.addedege(7,5,2);
        g.addedege(6,7,3);

        g.dfs(0,3);

    }
}
