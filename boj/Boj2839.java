package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2839 {
    private static StringTokenizer tokens;
    private static StringBuilder output = new StringBuilder();
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(input.readLine());
        int cnt=0;

        while(n>0) {
            if(n%5==0) {
                cnt+= n/5;
                n = n%5;
                continue;
            }
            n = n-3;
            cnt+=1;
        }
        if(n==0) System.out.println(cnt);
        else System.out.println(-1);


    }
}
