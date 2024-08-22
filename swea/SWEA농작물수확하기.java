package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA농작물수확하기 {
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokens;
    private static StringBuilder output = new StringBuilder();
    private static int map[][];
    private static int n;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(input.readLine());
        for(int t=1; t<=T; t++){
            n =Integer.parseInt(input.readLine());
            map = new int [n][n];
            for(int i=0; i<n; i++){
                String line = input.readLine();
                for(int j=0; j<n; j++){
                    map[i][j] = line.charAt(j) -'0';
                }
            }

            int mid = n/2;
            int total=0;
            //가운데를 기준으로 위부터 더해주기
            for(int i=0; i<=mid; i++){
                int start = mid -i;
                int end = mid +i ;
                for(int j=start; j<=end; j++){
                    total += map[i][j];
                }
            }
            //가운데를 기준으로 아래부터 더해주기
            for(int i=mid+1; i<n; i++){
                int start = i-mid;
                int end = n - (start);
                for(int j=start; j<end; j++){
                    total +=map[i][j];
                }
            }
            output.append("#").append(t).append(" ").append(total).append('\n');
        }
        System.out.print(output);
    }
}
