package s;

import java.io.*;
import java.util.StringTokenizer;
/**
 @author 한소리
 @since 2024. 8. 13.
 @link https://swexpertacademy.com/main/talk/solvingClub/problemSolverCodeDetail.do
 @timecomplex O(n!)
 @performance 20,384 kb 2,581 ms
 @category #permutation
 @note */
public class SWEA규영이와인영이의카드게임 {
    private static int t=0;
    private static int win_cnt, lose_cnt;
    private static StringTokenizer tokens;
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static int in_card[];
    private static int g_card[];
    public static void main(String[] args) throws IOException {

        t = Integer.parseInt(input.readLine());
        int i_card[] = new int[18];
        g_card = new int[9];
        in_card = new int[9];
        // 규영이 카드
        for(int test=1; test<t+1; test++) {
            StringBuilder output = new StringBuilder();
            win_cnt=0;
            lose_cnt=0;
            tokens = new StringTokenizer(input.readLine());
            for(int i=0; i<9; i++){
                g_card[i] = Integer.parseInt(tokens.nextToken());
            }
            for(int i=0; i<18; i++){
                i_card[i] = i+1;
            }

            //인영이카드
            for(int i=0; i<18; i++){
                for(int j=0; j<9; j++){
                    if(i_card[i] == g_card[j]){
                        i_card[i] =0;
                    }
                }
            }
            int size=0;
            for(int i : i_card){
                if(i!=0){
                    in_card[size++] = i;
                }
            }
            //인영이 카드 순열로 구함
            permutation(0, new int[9], new boolean[9]);
            output.append("#").append(test).append(" ").append(win_cnt).append(" ").append(lose_cnt);

            System.out.println(output);

        }

    }

    //순열 만들기
    private static void permutation(int cnt, int i_card[], boolean visited[]){
        //기저상황
        //규영이 기준으로 생각할것
        if(cnt == 9) {
            int g_total=0, in_total=0;
            for(int i=0; i<9; i++){
                if(i_card[i]<g_card[i]){ //규영이가 큰거니까 점수 구함
                    g_total += (g_card[i]+i_card[i]);
                }
                else{
                    in_total += (g_card[i]+i_card[i]);
                }
            }
            if(g_total > in_total) win_cnt++;
            else lose_cnt++;
            return;
        }
        //재귀상황
        for(int i=0; i<9; i++){
            if(!visited[i]){
                visited[i] = true;
                i_card[cnt] = in_card[i];
                permutation(cnt+1, i_card, visited);
                visited[i] = false;
            }
        }
    }
}
