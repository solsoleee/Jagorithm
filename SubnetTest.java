import java.io.IOException;
import java.util.*;
public class SubnetTest {
    private static int n;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        visited = new boolean[n];
        arr = new int [n];
        for(int i=0; i<n; i++){
            arr[i] = i;
        }
        subset(0);
    }
    private static void subset(int cnt){
        if(cnt == n){
            for(int i=0; i<n; i++){
                if(visited[i]){
                    System.out.print(arr[i]);
                }
            }
            System.out.println();
            return;
        }
        visited[cnt] = true;
        subset(cnt+1);
        visited[cnt] = false;
        subset(cnt+1);
    }
}
