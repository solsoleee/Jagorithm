package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA수제버거장인 {
    private static StringTokenizer tokens;
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder output = new StringBuilder();
    private static int n,m;
    private static int a_arr[], b_arr[];
    private static boolean visited[];
    private static int res;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(input.readLine());
        for(int t=1; t<=T; t++){
            res = 0;
            tokens = new StringTokenizer(input.readLine());
            n = Integer.parseInt(tokens.nextToken());
            m = Integer.parseInt(tokens.nextToken());

            visited = new boolean[n+1];
            a_arr = new int [m];
            b_arr = new int [m];
            for(int i=0; i<m; i++){
                tokens = new StringTokenizer(input.readLine());
                a_arr[i] = Integer.parseInt(tokens.nextToken());
                b_arr[i] = Integer.parseInt(tokens.nextToken());
            }
            subSet(1); //1번 패티부터 선택
            output.append("#").append(t).append(" ").append(res).append('\n');
        }
        System.out.print(output);
    }
    private static void subSet(int cnt){
        if(cnt == n+1){
            if(check()) res++;
            return;
        }
        visited[cnt] = true;
        subSet(cnt+1);
        visited[cnt] = false;
        subSet(cnt+1);
    }

    private static boolean check(){ //햄버거 패티가 들어가 있는지 체크
        for(int i=0; i<m; i++){
            if(visited[a_arr[i]] && visited[b_arr[i]]) return false;
        }
        return true;
    }
}
