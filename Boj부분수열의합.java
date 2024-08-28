import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj부분수열의합 {
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokens;
    private static StringBuilder output = new StringBuilder();
    private static int n,s;
    private static int arr[];
    private static boolean visited[];
    public static void main(String[] args) throws IOException {

        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        s = Integer.parseInt(tokens.nextToken());
        arr = new int [n];
        visited = new boolean[n];
    }

    //부분집합 사용
    private static void subSet(int cnt){
       if(cnt == n){
           return;
       }
       //visited

    }
}
