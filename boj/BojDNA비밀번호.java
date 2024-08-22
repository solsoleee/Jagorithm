package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BojDNA비밀번호 {
    private static StringTokenizer tokens;
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder output = new StringBuilder();
    private static int minCount[] = new int [4];
    private static int currentCount[] = new int [4];
    private static int res;

    public static void main(String[] args) throws IOException {

        tokens = new StringTokenizer(input.readLine());
        int s = Integer.parseInt(tokens.nextToken());
        int p = Integer.parseInt(tokens.nextToken());
        String dna = input.readLine();
        tokens = new StringTokenizer(input.readLine());
        for(int i=0; i<4; i++){
            minCount[i] = Integer.parseInt(tokens.nextToken());
        }
        //초기 윈도우 계산
        for(int i=0; i<p; i++){
            addCheck(dna.charAt(i));
        }
        //해당되는지 체크
        if(isVaild()) res++;

        //윈도우
        for(int i=p; i<s; i++) {
            removeCheck(dna.charAt(i-p)); //처음원소제거
            addCheck(dna.charAt(i));
            if(isVaild()) res++;
        }
        System.out.print(res);
    }


    private static boolean isVaild(){
        if(minCount[0] <= currentCount[0] &&
                minCount[1] <=currentCount[1] &&
                minCount[2] <=currentCount[2] &&
                minCount[3] <= currentCount[3]){
            return true;
        }
        return false;
    }
    private static void removeCheck(char c){
        switch (c){
            case 'A':
                currentCount[0]--;
                break;
            case 'C':
                currentCount[1]--;
                break;
            case 'G':
                currentCount[2]--;
                break;
            case 'T':
                currentCount[3]--;
                break;
        }
    }
    private static void addCheck(char c){
        switch (c){
            case 'A':
                currentCount[0]++;
                break;
            case 'C':
                currentCount[1]++;
                break;
            case 'G':
                currentCount[2]++;
                break;
            case 'T':
                currentCount[3]++;
                break;
        }
    }
}
