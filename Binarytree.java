
import java.util.*;

public class Binarytree {
    public class Node{
        int val;
        Node left;
        Node right;
    }
    Scanner sc = new Scanner(System.in);
    private Node root;
    public Binarytree(){
        root = createroot();
    }
    private Node createroot(){
        int item = sc.nextInt();
        Node nn = new Node();
        nn.val = item;
        boolean hlc = sc.nextBoolean();
        if(hlc){
            nn.left = createroot();
        }
        boolean hrc = sc.nextBoolean();
        if(hrc){
            nn.right = createroot();
        }
        return nn;
    }

    public void display(){
        display(root);
    }

    private  void display(Node node){
        if(node == null){
            return;
        }
        String s = "";
        s = "<--"+node.val+"-->";
        if(node.left != null){
            s += node.left.val+s;
        }else{
            s = "."+s;
        }
        if(node.right != null){
            s += node.right.val;
        }else{
            s += ".";
        }
        System.out.println(s);
        display(node.left);
        display(node.right);

    }

    // for finding an element


    public boolean find(int item) {
        return find(this.root,item);
    }

    private boolean find(Node node, int item){
        if(node == null){
            return false;
        }
        if(node.val == item){
            return true;
        }

        boolean l = find(node.left,item);
        boolean r = find(node.right,item);
        return l || r;
    }

    public int max(){
        return max(this.root);
    }
    private int max(Node node){
        if(node == null){
            return Integer.MIN_VALUE;
        }
        int l = max(node.left);
        int r = max(node.right);
        return Math.max(node.val,Math.max(l,r));
    }

    public int ht(){
        return ht(this.root);
    }

    private int ht(Node node){
        if(node == null){
            // return 0; if you want to consider leaf heigth 1;
            // return -1; if you want to consider leaf height 0;
            return -1;

        }

        int l = ht(node.left);
        int r = ht(node.right);
        return Math.max(l,r)+1;
    }

    public void preorder(){
        preorder(this.root);
        System.out.println();
    }
    private void preorder(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.val+" ");
        preorder(node.left);
        preorder(node.right);
    }

    public void postorder(){
        postorder(this.root);
        System.out.println();
    }
    private void postorder(Node node){
        if(node == null){
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.val+" ");
    }
    public void inorder(){
        inorder(this.root);
        System.out.println();
    }
    private void inorder(Node node){
        if(node == null){
            return;
        }
        inorder(node.left);
        System.out.print(node.val+" ");
        inorder(node.right);
    }

    public void levelOrder(){
        levelOrder(this.root);
        System.out.println();
    }
    private void levelOrder(Node node){
        if(root == null){
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node rv = q.poll();
            System.out.print(rv.val);
            if(rv.left != null){
                q.offer(rv.left);
            }
            if(rv.right != null){
                q.offer(rv.right);
            }

            System.out.println();
        }

    }

    public void BST(int[] in){
        root =CreateTree(in,0,in.length-1);
    }
    public Node CreateTree(int[]in,int si,int ei){
        if(si>ei){
            return null;
        }
        int mid = si + (ei-si)/2;
        Node nn = new Node();
        nn.val = in[mid];
        nn.left = CreateTree(in,si,mid-1);
        nn.right = CreateTree(in,mid+1,ei);
        return nn;
    }

    public static void main(String[] args) {
        Binarytree t = new Binarytree();
        t.display();
    }
}
