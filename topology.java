import java.util.*;

public class topology {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Map<Integer, Integer> edgesCount = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            edgesCount.put(x, edgesCount.getOrDefault(x, 0) + 1);
            edgesCount.put(y, edgesCount.getOrDefault(y, 0) + 1);
        }

        int bus = 0, ring = 0, star = 0;
        for (int count : edgesCount.values()) {
            if (count == 1) {
                bus++;
            } else if (count == 2) {
                ring++;
            } else if (count == n - 1) {
                star++;
            }
        }

        if (bus == 2 && ring == n - 2) {
            System.out.println("bus topology");
        } else if (ring == n) {
            System.out.println("ring topology");
        } else if (star == 1 && bus == n - 1) {
            System.out.println("star topology");
        } else {
            System.out.println("unknown topology");
        }
    }
}
