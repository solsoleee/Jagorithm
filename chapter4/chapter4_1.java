package chapter4;

import java.awt.image.DataBufferDouble;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class chapter4_1 {

    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    private static StringTokenizer tokens;
    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner sc = new Scanner(System.in);
        int deltas[][] = {{1,2}, {1,-2}, {-1,2}, {-1,-2}, {2,1}, {-2,-1}, {2,-1}, {-2,1}};

        int map[][] = new int[8][8];

        int count=0;

        String s = sc.nextLine();
        int x = s.charAt(0)-'a';
        int y = s.charAt(1)-'1';

        for(int d[] : deltas){
            int nx = x+d[0];
            int ny = y+d[1];
            if(nx >=0 && nx<8 && ny >=0 && ny<8 && map[nx][ny]==0){
                count+=1;
                map[nx][ny]=1;
            }
        }

        System.out.println(count);
    }






}
