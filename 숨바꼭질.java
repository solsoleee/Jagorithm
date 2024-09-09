import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숨바꼭질 {
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokens;
    private static StringBuilder output = new StringBuilder();
    private static int n,m;
    static long distance[][];

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        m = Integer.parseInt(tokens.nextToken());
        distance = new long[n+1][n+1];
        int INF = Integer.MAX_VALUE;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(i!=j) distance[i][j] = INF;
            }
        }

        for(int i=0; i<m; i++) {
            tokens = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(tokens.nextToken());
            int b = Integer.parseInt(tokens.nextToken());
            distance[a][b] = 1;
            distance[b][a] = 1;
        }

        for(int k=1; k<=n; k++) {
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }
        long d = 0;
        int idx=0;
        for(int i=1; i<=n; i++) {
            if( d < distance[1][i]) {
                idx = i;//번호
                d = distance[1][i]; //최단거리
            }
        }
        //count찾기
        int count=0;
        for(int i=1; i<=n; i++) {
            if( d == distance[1][i]) {
               count++;
            }
        }

        //System.out.println(Arrays.deepToString(distance));
        System.out.print(idx + " " + d + " " + count);
    }
}
