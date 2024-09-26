import java.util.Scanner;

public class ans {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while(t-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();
            String a = scanner.next();
            int curr_index = m - 1;
            int swim = 0;
            int f = 0;

            for (int i = 0; i < a.length(); i++) {
                char action = a.charAt(i);

                if (action == 'L') {
                    curr_index = m;
                } else if (action == 'W') {
                    if (curr_index <= 0) swim++;
                } else {
                    if (curr_index <= 0) f++;
                }
                curr_index--;
            }

            if (swim > k) f++;

            System.out.println(f != 0 ? "NO" : "YES");
        }
    }
}
