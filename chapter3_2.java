import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class chapter3_2 {
    private static StringTokenizer tokens;
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int m= sc.nextInt();
        int [][] arr = new int [n][m];


        int max_value = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            int min_value = Integer.MAX_VALUE;
            for(int j=0; j<m; j++){
                arr[i][j] = sc.nextInt();
                min_value = Math.min(arr[i][j], min_value); //행에서 가장 작은거
            }
            max_value = Math.max(max_value, min_value); //행에서 가장 작은거 중에 큰거
        }
        System.out.println(max_value);


    }
}
