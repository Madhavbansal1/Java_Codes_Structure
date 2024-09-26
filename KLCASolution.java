//import java.util.*;
//
//public class KLCASolution{
//
//    // Function to create a binary tree from array representation
//    public static Node createTree(int[] a, int i) {
//        if (i >= a.length || a[i] == -1) return null;
//
//        Node newNode = new Node(a[i]);
//        newNode.left = createTree(a, 2 * i + 1);
//        newNode.right = createTree(a, 2 * i + 2);
//
//        return newNode;
//    }
//
//    // Function to find k-th ancestor of lowest common ancestor of nodes p and q
//    public static int findKLCA(Node root, int p, int q, int k) {
//        // implement your code here
//        ArrayList<Integer> pathToP = new ArrayList<>();
//        ArrayList<Integer> pathToQ = new ArrayList<>();
//
//        findPath(root, p, new ArrayList<>(), pathToP);
//        findPath(root, q, new ArrayList<>(), pathToQ);
//
//// System.out.print(pathToP);
//// System.out.print(pathToQ);
//        ArrayList<Integer> common = new ArrayList<>();
//
//        int i = 0;
//        while (i < pathToP.size() && i < pathToQ.size() && pathToP.get(i).equals(pathToQ.get(i))) {
//            common.add(pathToP.get(i));
//            i++;
//        }
//
//        if (common.size() > k) {
//            return common.get(k - 1);
//        } else {
//            return -1;
//        }
//    }
//
//
//
//
//        public static boolean findPath(Node root, int target, List<Integer> currentPath, List<Integer> result) {
//            if (root == null) {
//                return false;
//            }
//
//            currentPath.add(root.data);
//
//            if (root.data == target) {
//                result.addAll(new ArrayList<>(currentPath));
//                return true;
//            }
//
//            if (findPath(root.left, target, currentPath, result) || findPath(root.right, target, currentPath, result)) {
//                return true;
//            }
//
//            currentPath.remove(currentPath.size() - 1);
//
//            return false;
//        }
//
//
//
//
//
//    // Main function
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        // Read n, m and k
//        int n = sc.nextInt(); // Size of array a
//        int m = sc.nextInt(); // Number of pairs (p, q)
//        int k = sc.nextInt();
//
//        // Read array a
//        int[] a = new int[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = sc.nextInt();
//        }
//
//        // Read pairs (p, q)
//        int[][] pairs = new int[m][2];
//        for (int i = 0; i < m; i++) {
//            pairs[i][0] = sc.nextInt();
//            pairs[i][1] = sc.nextInt();
//        }
//
//        sc.close();
//
//        // Create the binary tree
//        Node root = createTree(a, 0);
//
//        // Find k-th ancestor of lowest common ancestor for each pair (p, q)
//        for (int i = 0; i < m; i++) {
//            int p = pairs[i][0];
//            int q = pairs[i][1];
//            int lca = findKLCA(root, p, q, k);
//            System.out.println(lca);
//        }
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