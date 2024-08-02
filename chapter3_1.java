import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class chapter3_1 {

    private static StringTokenizer tokens;
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        tokens = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(tokens.nextToken());
        int m = Integer.parseInt(tokens.nextToken());
        int k = Integer.parseInt(tokens.nextToken());

        int arr[] = new int[n];



        tokens = new StringTokenizer(input.readLine());
        for(int i=0; i<n; i++){
            arr[i]=Integer.parseInt(tokens.nextToken());
        }
        Arrays.sort(arr);
        int total=0;
        for(int i=1; i<=m; i++){
            if (i%3==0){
                total+=arr[n-2];
            }
            else{
                total+=arr[n-1];
            }
        }
        System.out.println(total);

    }
}
