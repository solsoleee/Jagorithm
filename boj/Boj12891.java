package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj12891 {
    private static StringTokenizer tokens;
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder output = new StringBuilder();
    private static int s,p,res,a,c,g,t;
    private static boolean visited[];
    private static String dna[],arr[];
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        s = Integer.parseInt(tokens.nextToken());
        p = Integer.parseInt(tokens.nextToken());
        visited = new boolean[s];
        String dnaString = input.readLine();
        dna = new String[s];
        arr = new String[p];
        dna = dnaString.split("");
        tokens = new StringTokenizer(input.readLine());
        a =Integer.parseInt(tokens.nextToken());
        c =Integer.parseInt(tokens.nextToken());
        g = Integer.parseInt(tokens.nextToken());
        t = Integer.parseInt(tokens.nextToken());
        combi(0,0);
        System.out.println(res);
    }
    private static void combi(int start, int cnt){
        if(cnt == p) {
            if(check()) res++;
            return;
        }

        for(int i = start; i<s; i++){
            if(!visited[i]){
                visited[i] =true;
                arr[cnt] = dna[i];
                combi(i+1, cnt+1);
                visited[i] = false;
            }
        }

    }

    private static boolean check(){ //개수가 있는지 체크
        int a_cnt=0, c_cnt=0, g_cnt=0, t_cnt=0;
        for(String a: arr){
            if(a.equals("A")) a_cnt++;
            else if(a.equals("C")) c_cnt++;
            else if(a.equals("G")) g_cnt++;
            else if(a.equals("T")) t_cnt++;
        }
        if(a_cnt >= a && c_cnt >= c &&g_cnt >= g &&t_cnt >= t) return true;
        return false;
    }

}
