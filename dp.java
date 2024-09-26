public class dp {
    public static void main(String[] args) {
        int n = 7;

    }
    public int fabo(int n){
        if(n == 0 || n == 1){
            return n;
        }

        return fabo(n-1) + fabo(n-2);
    }
}

