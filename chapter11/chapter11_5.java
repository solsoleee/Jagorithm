package chapter11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class chapter11_5 {
    private static StringTokenizer tokens;
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        int n = Integer.parseInt(input.readLine());
        int arr [] = new int[n];
        tokens = new StringTokenizer(input.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(tokens.nextToken());
        }
        Arrays.sort(arr);
        int min_value=1;
        for(int a: arr){
            if(min_value < a){
                break;
            }
            else{
                min_value +=a;
            }
        }
        System.out.println(min_value);

}

}
