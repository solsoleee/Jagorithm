import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj10971 {
    private static StringTokenizer tokens;
    private static StringBuilder output = new StringBuilder();
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m, sum_val, total;
    static int [][]map;
    static boolean [] visited;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(input.readLine());
        sum_val = Integer.MAX_VALUE;
        total = 0;
        visited = new boolean[n];
        map = new int [n][n];
        for(int i=0; i<n; i++){
            tokens = new StringTokenizer(input.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }
        bfs(0,0);
        visited[0] = true;
        System.out.println(sum_val);

    }
    static void bfs(int depth, int x){
        //종료조건
        if(depth == n-1){
            //처음부터 시작된 것 고른다
            if(map[x][0]!=0){
                total += map[x][0];// 처음 시작을 더해주기
                sum_val = Math.min(sum_val, total);
                total -= map[x][0];
            }
            return;
        }
        for(int i=1; i<n; i++){ //갈수 있는 경우를 다 구하기
            if(!visited[i] && map[x][i]!=0){
                total +=map[x][i]; //방문하기
                visited[i] =true;
                bfs(depth+1, i);
                //백트레킹
                visited[i] = false;
                total -= map[x][i];
            }


        }
    }



}
