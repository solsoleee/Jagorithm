import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class chapter11_1 {
    private static StringTokenizer tokens;
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws NumberFormatException, IOException {

        int n=Integer.parseInt(input.readLine());
        int [] arr =new int[n];

        int total=0;

        tokens = new StringTokenizer(input.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(tokens.nextToken());
        }
        Arrays.sort(arr);

        int group=1;
        for(int a: arr){

            if(a==group){
                total+=1;
                group=1;
            }
            else{
                group+=1;
            }
        }
        System.out.println(total);

    }
}
