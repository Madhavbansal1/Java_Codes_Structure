import java.util.ArrayList;

public class heap {
    private ArrayList<Integer> ll = new ArrayList<>();

    public void add(int item) {
        ll.add(item);
        unheapify(ll.size()-1);
    }
    public void unheapify(int ci){
        int pi = (ci-1)/2;
        if(ll.get(pi)>ll.get(ci)){
            swap(ci,pi);
            unheapify(pi);
        }
    }

    public void swap(int i, int j) {
        int ith = ll.get(i);
        int jth = ll.get(j);
        ll.set(i, jth);
        ll.set(j, ith);
    }

    public int remove(){
        swap(0,ll.size()-1);
        int rv = ll.remove(ll.size()-1);
        dowmheapify(0);
        return rv;
    }
    public void dowmheapify(int pi){
        int lci  = 2*pi+1;
        int rci  = 2*pi+2;
        int mini = pi;
        if(lci < ll.size() && ll.get(lci)<ll.get(mini)){
            mini = lci;
        }
        if(rci < ll.size() && ll.get(rci)<ll.get(mini)) {
            mini = rci;
        }
        if(mini != pi){
            swap(mini,pi);
            dowmheapify(mini);
        }
    }
    public int get(){
        return ll.get(0);
    }
    public void display(){
        System.out.println(ll);
    }

    public static void main(String[] args){
        heap h = new heap();
        h.add(10);
        h.add(20);
        h.add(30);
        h.add(4);
        h.add(5);
        h.add(6);

        System.out.println(h.get());
        h.display();
    }

}
