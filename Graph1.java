
import java.util.*;

public class Graph1 {
    private final HashMap<Integer,HashMap<Integer,Integer>> graph;
    public Graph1(int n){
        graph = new HashMap<>();
        for(int i = 1; i<=n; i++){
            graph.put(i, new HashMap<>());
        }
    }

    public void addedege(int v1, int v2, int cost){
        graph.get(v1).put(v2, cost);
        graph.get(v2).put(v1, cost);
    }

    public boolean containsEdege( int v1, int v2){
        return graph.get(v1).containsKey(v2);
    }
    public boolean containsvertices(int v1){
        return graph.containsKey(v1);
    }
    public int noofedges(){
        int sum = 0;
        for(int i=1; i<=graph.size(); i++){
            sum += graph.get(i).size();
        }

        return sum/2;
    }

    public void removeEdge(int v1, int v2){
        if(containsEdege(v1, v2)){
            graph.get(v1).remove(v2);
            graph.get(v2).remove(v1);
        }
    }

    public void removevertices(int v1){
        for(int i=0; i<graph.get(v1).size(); i++){
            int nbrs = graph.get(v1).get(i);
            graph.get(nbrs).remove(v1);
        }

        graph.remove(v1);
    }

    public void print(){
        for(int i=1; i<=graph.size(); i++){
            System.out.println(i+" "+graph.get(i));
        }
    }

    public boolean hashpath(int src, int des, HashSet<Integer> visited){
        if(src == des){
            return true;
        }
        visited.add(src);
        for(int nbr: graph.get(src).keySet()){
            if(!visited.contains(nbr)) {
                boolean ans = hashpath(nbr, des, visited);
                if (ans) {
                    return true;
                }
            }
        }
        visited.remove(src);
        return false;
    }
//    this code give stack overflow;

    public void printAllPaths(int src, int des, HashSet<Integer> visited,String ans){
        if(src ==  des){
            System.out.println(ans+src);
            return;
        }
        visited.add(src);
        for(int nbr: graph.get(src).keySet()){
            if(!visited.contains(nbr)) {
                printAllPaths(nbr, des, visited, ans+src+"->");
            }
        }
        visited.remove(src);
    }

    public boolean bfs(int src, int des){
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        while(!q.isEmpty()){
            // 1. remove
            int rm = q.poll();
            // 2. ignore if already visited
            if(visited.contains(rm)){
                continue;
            }
            // 3. marked visited
            visited.add(rm);

            // 4. self worked
            if(rm == des){
                return true;
            }

            // 5. add nbrs

            for(int nbr: graph.get(rm).keySet()){
                if(!visited.contains(nbr)) {
                    q.offer(nbr);
                }
            }
        }

        return false;

    }


    public boolean dfs(int src, int des){

        Stack<Integer> q = new Stack<>();
        HashSet<Integer> visited = new HashSet<>();

        q.push(src);
        while(!q.isEmpty()) {
            // 1. remove
            int rm = q.pop();
            // 2. ignore if already visited
            if (visited.contains(rm)) {
                System.out.println("Cycle detect");
                continue;
            }
            // 3. marked visited
            visited.add(rm);

            // 4. self worked
            if (rm == des) {
                return true;
            }

            // 5. add nbrs

            for (int nbr : graph.get(rm).keySet()) {
                if (!visited.contains(nbr)) {
                    q.push(nbr);
                }
            }
        }
        return false;
    }

    public void bft(){
         HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        for(int src: graph.keySet()) {
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
                System.out.print(rm + " ");

                // 5. add nbrs

                for (int nbr : graph.get(rm).keySet()) {
                    if (!visited.contains(nbr)) {
                        q.offer(nbr);
                    }
                }
                System.out.println();
            }
        }
    }

    public void dft(){
        Stack<Integer> q = new Stack<>();
        HashSet<Integer> visited = new HashSet<>();
        for(int src: graph.keySet()) {
            if (visited.contains(src)) {
                continue;
            }
            q.push(src);
            while(!q.isEmpty()) {
            // 1. remove
                int rm = q.pop();
            // 2. ignore if already visited
                if (visited.contains(rm)) {
                continue;
                }
            // 3. marked visite
                 visited.add(rm);

            // 4. self worked
                System.out.print(rm +" ");
            // 5. add nbrs

                for (int nbr : graph.get(rm).keySet()) {
                    if (!visited.contains(nbr)) {
                        q.push(nbr);
                    }
                }
            }
        }
    }



}
