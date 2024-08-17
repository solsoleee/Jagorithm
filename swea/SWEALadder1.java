package swea;
import java.io.*;
import java.util.*;
public class SWEALadder1 {
    private static StringTokenizer tokens;
    private static StringBuilder output = new StringBuilder();
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        for(int T=1; T<=10; T++){
            int t = Integer.parseInt(input.readLine());
            int ladder[][] = new int[100][100];
            int c = -1;
            //사다리 저장, [row][column]에서 c 찾기
            for(int i=0; i<100; i++){
                tokens =new StringTokenizer(input.readLine());
                for(int j=0; j<100; j++){
                    ladder[i][j] = Integer.parseInt(tokens.nextToken());
                    if(ladder[i][j]==2){
                        c = j;
                    }
                }
            }
            //[99][c]에서 위로 올라가서
            //[0][정답]이 되는 것을 찾기
            int row = 99;
            while(row > 0){
                //왼쪽으로 가는 방향이 있고, 가는길(1)이 있다면
                if(c-1 >=0 && ladder[row][c-1]==1){
                    //왼쪽 길이 끝날때까지 왼쪽으로 가기
                    while(c-1 >=0 && ladder[row][c-1]==1){
                        c--;
                    }
                }
                //오른쪽 길이 있다면 오른쪽으로 가기
                else if(c+1<=99 && ladder[row][c+1]==1){
                    //왼쪽 길이 끝날때까지 왼쪽으로 가기
                    while(c+1<=99 && ladder[row][c+1]==1){
                        c++;
                    }
                }
                //둘다 없다면 그냥 위로 올라가기
                row--;
            }
            output.append("#").append(t).append(" ").append(c).append('\n');
        }
        System.out.print(output);
    }
}
