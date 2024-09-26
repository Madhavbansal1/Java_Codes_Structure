import java.util.*;

public class HashMap_Implementation <k,v> {
    private int size ;
    class Node{
        k key;
        v value;
        Node next;
    }
    ArrayList<Node> bukt;
    public HashMap_Implementation(){
        this(4);
    }
    public HashMap_Implementation(int n){
        bukt = new ArrayList<>();
        for(int i=0;i<n;i++){
            bukt.add(null);
        }
    }
    public void put(k key,v value){
        int idx = hashfun(key);
        Node temp = bukt.get(idx);
        while(temp!=null){
            if(temp.key.equals(key)){
                temp.value = value;
                return;
            }
            temp = temp.next;
        }
        temp = bukt.get(idx);
        Node nn = new Node();
        nn.key = key;
        nn.value = value;
        nn.next = temp;
        bukt.set(idx, nn);
        size++;
        double lf = (1.0+size)/bukt.size();
        double thf = 2.0;
        if(lf>thf){
            rehashing();
        }
    }
    private void rehashing(){
        ArrayList<Node> new_bukt = new ArrayList<>();
        for(int i=0; i<2*bukt.size(); i++){
            new_bukt.add(null);
        }
        ArrayList<Node> old_bukt = bukt;
        bukt = new_bukt;
        size = 0;
        for(Node n: old_bukt){
            while(n!= null){
                put(n.key,n.value);
                n = n.next;
            }
        }
    }
    @Override
    public String toString(){
        String s ="{";
        for(Node n: bukt){
            while(n!= null){
                s = s+n.key+"="+n.value+",";
                n = n.next;
            }
        }

        return s+"}";
    }
    public int hashfun(k key){
        int bn = key.hashCode()%bukt.size();
        if(bn<0) {
            bn += bukt.size();
        }

        return bn;
    }

    public boolean contains(k key){
        int idx = hashfun(key);
        Node temp = bukt.get(idx);
        while(temp!=null){
            if(temp.key.equals(key))
                return true;
            temp = temp.next;
        }
        return false;

    }
    public v get(k key) {
        int idx = hashfun(key);
        Node temp = bukt.get(idx);
        while(temp!=null){
            if(temp.key.equals(key))
                return temp.value;
            temp = temp.next;
        }
        return null;

    }
    public v remove(k key) {
        int idx = hashfun(key);
        Node curr = bukt.get(idx);
        Node prev = null;
        while (curr != null) {
            if (curr.key.equals(key)) {
                break;
            }
            prev = curr;
            curr = curr.next;

        }
        if (curr == null) return null;
        if (prev == null) {
            bukt.set(idx, curr.next);
            size--;
        }
        else{
            prev.next = curr.next;
            size--;
        }

        return curr.value;
    }

}
