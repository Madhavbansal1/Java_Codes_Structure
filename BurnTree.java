//import java.util.*;
//
//public class BurnTree {
//    public static long findTemperature(Node root, int[] initialVertexValues) {
//        Map<Integer, Integer> vertexToTime = new HashMap<>();
//
//        for (int i = 0; i < initialVertexValues.length; i++) {
//            burnVertex(root, initialVertexValues[i], 0, vertexToTime);
//        }
//
//        long totalTemperature = 0;
//        Queue<Node> queue = new LinkedList<>();
//        queue.add(root);
//
//        while (!queue.isEmpty()) {
//            Node current = queue.poll();
//            int temp = vertexToTime.get(current.data) * getMinDistanceFromInitialBurnt(vertexToTime, current.data);
//
//            totalTemperature += temp;
//
//            if (current.left != null) {
//                queue.add(current.left);
//            }
//            if (current.right != null) {
//                queue.add(current.right);
//            }
//        }
//
//        return totalTemperature;
//    }
//
//    public static void burnVertex(Node node, int targetVertex, int time, Map<Integer, Integer> vertexToTime) {
//        if (node == null) {
//            return;
//        }
//
//        if (node.data == targetVertex) {
//            vertexToTime.put(targetVertex, time);
//            return;
//        }
//
//        burnVertex(node.left, targetVertex, time + 1, vertexToTime);
//        burnVertex(node.right, targetVertex, time + 1, vertexToTime);
//    }
//
//    public static int getMinDistanceFromInitialBurnt(Map<Integer, Integer> vertexToTime, int vertex) {
//        int minDistance = Integer.MAX_VALUE;
//        for (int key : vertexToTime.keySet()) {
//            int distance = findDistance(vertexToTime, key, vertex);
//            minDistance = Math.min(minDistance, distance);
//        }
//        return minDistance;
//    }
//
//    public static int findDistance(Map<Integer, Integer> vertexToTime, int source, int target) {
//        return Math.abs(vertexToTime.get(source) - vertexToTime.get(target));
//    }
//
//    public static Node createTree(int a[], int i) {
//        if (i >= a.length || a[i] == -1) return null;
//        Node newnode = new Node(a[i]);
//        newnode.left = createTree(a, 2 * i + 1);
//        newnode.right = createTree(a, 2 * i + 2);
//        return newnode;
//    }
//
//    public static void main(String args[]) {
//        int n, k;
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        k = sc.nextInt();
//        int a[] = new int[n];
//        // read values
//        for (int i = 0; i < n; i++) {
//            a[i] = sc.nextInt();
//        }
//
//        int b[] = new int[k];
//        for (int i = 0; i < k; i++) {
//            b[i] = sc.nextInt();
//        }
//
//        sc.close();
//        Node root = createTree(a, 0);
//
//        System.out.println(findTemperature(root, b));
//    }
//}
//
//class Node {
//    int data;
//    Node left, right;
//
//    Node(int data) {
//        this.data = data;
//        left = right = null;
//    }
//}
//
