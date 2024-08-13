package s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 햄스터 {


    private static int t=0;
    private static StringTokenizer tokens;
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(input.readLine());


        tokens = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(tokens.nextToken()); //우리의 개수
        int x = Integer.parseInt(tokens.nextToken()); //각 우리 최대 마리
        int m = Integer.parseInt(tokens.nextToken()); //기록

        int[] map = new int[n];

        for(int i=0; i<m; i++){
            tokens = new StringTokenizer(input.readLine());
            int l = Integer.parseInt(tokens.nextToken());
            int r = Integer.parseInt(tokens.nextToken());
            int s = Integer.parseInt(tokens.nextToken());
            for(int left=0; l<left; left++){

                //L 번 부터 R.번.....

            }

        }



    }



}
