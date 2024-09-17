package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1074 {
    private static StringTokenizer tokens;
    private static StringBuilder output = new StringBuilder();
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static int n,count;
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        int r = Integer.parseInt(tokens.nextToken());
        int c = Integer.parseInt(tokens.nextToken());

        count = 0;
        int size = (int) Math.pow(2, n);
        find(size, r,c);
        System.out.println(count);
    }


    static void find(int size, int row, int col) {
           if(size == 1) {
               return;
           }
           if(size / 2 > row && size/2 > col) { //1사분면
               find(size/2, row, col);
           }
           else if(size/2 >row && col >= size/2) { //2사분면
               count += size*size/4;
               find(size/2, row, col-size/2);
           }
           else if(size/2 <= row && size/2 > col){ //3사분면
               count += (size*size/4) *2;
               find(size/2, row-size/2, col);
           } else if (size/2 <=row && size/2 <=col) { //4사분면
               count +=(size*size/4) *3;
               find(size/2, row-size/2, col-size/2);
           }

    }
}