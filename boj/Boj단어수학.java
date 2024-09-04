package boj;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Boj단어수학 {
    public static void main(String[] args) throws IOException {

        Scanner sc =new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        int alph[] = new int[26];
        for(int i=0; i<n; i++){
            String line = sc.nextLine();
            System.out.println(line);
            for(int j=0; j<line.length(); j++){
                if(j == line.length()-1){
                    alph[line.charAt(j)-'A'] +=1;
                }
                else{
                    alph[line.charAt(j)-'A'] += Math.pow(10, line.length()-j-1);
                }
            }
        }
        Arrays.sort(alph);
        int res=0;
        int j = 9;
        for(int i = 25; i>=16; i--){
            res += alph[i] * j;
            j--;
        }
        System.out.println(res);
    }
}
