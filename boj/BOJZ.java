package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJZ {
    private static StringTokenizer tokens;
    private static StringBuilder output = new StringBuilder();
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static int n,row,col,count;
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        row = Integer.parseInt(tokens.nextToken());
        col = Integer.parseInt(tokens.nextToken());
        int size = (int) Math.pow(2, n);
        find(row, col, size);
        System.out.println(count);
    }
    private static void find(int r, int c, int size){
        if(size == 1) {
            return;
        }
        if(r < size/2 && c < size/2) { // 1사분면
            find(r,c,size/2);
        }
        else if(r< size/2 && c >= size/2){ //2사분면
            find(r, c-size/2, size/2);
            count += size*size/4;
        }
        else if(r >= size/2 && c<size/2 ) { //3사분면
            find(r-size/2, c,size/2);
            count += (size*size/4)*2;
        }
        else if(r>=size/2 && c>=size/2) { //4사분면
            find(r-size/2, c-size/2, size/2);
            count += (size*size/4)*3;
        }
    }
}
