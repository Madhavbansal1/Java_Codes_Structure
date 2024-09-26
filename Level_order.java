import javax.print.attribute.IntegerSyntax;
import java.sql.SQLOutput;
import java.util.*;

public class Level_order {
    public static void main(String[] args) {
        int b = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, List<Integer>> a = new HashMap<>();
        for(int i=1; i<=n; i++){
            a.put(i,new ArrayList<>());
        }
        for(int i=1;i<n; i++){
            int m = sc.nextInt();
            int k = sc.nextInt();

            a.get(m).add(k);
            a.get(k).add(m);

        }
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        ArrayList<Integer> visited = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int src: a.keySet()) {
            if (visited.contains(src)) {
                continue;
            }
            q.offer(src);
            while (!q.isEmpty()) {
                // 1. remove
                int rm = q.poll();
                // 2. ignore if already visited
                if (visited.contains(rm)) {
                    continue;
                }
                // 3. marked visited
                visited.add(rm);

                // 4. self worked


                // 5. add nbrs

                for (int nbr : a.get(rm)) {
                    if (!visited.contains(nbr)) {
                        q.offer(nbr);
                    }
                }
            }
        }
        for(int i=0; i<n; i++){
            if(arr[i] != visited.get(i)){
                System.out.println("No");
                b = 1;
                break;
            }
        }

        if(b == 0){
            System.out.println("Yes");
        }




    }
}
