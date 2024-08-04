import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chaper3_3 {
    private static StringTokenizer tokens;
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws NumberFormatException, IOException {
        tokens = new StringTokenizer(input.readLine());

        int n = Integer.parseInt(tokens.nextToken());
        int k = Integer.parseInt(tokens.nextToken());

        int count=0;
        while(n!=1){
            if(n%k==0){
                count+=1;
                n/=k;
            }
            else{
                n-=1;
                count+=1;
            }
        }
        System.out.println(count);
    }
}
