import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chapter11_2 {
    private static StringTokenizer tokens;
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws NumberFormatException, IOException {

        tokens = new StringTokenizer(input.readLine());
        String number =tokens.nextToken();


        int num1=number.charAt(0)-'0'; //처음꺼

        for(int i=0; i< number.length()-1; i++){
            int num2 = number.charAt(i)-'0'; //현재

            if (num1==0|| num2==1 || num1==0 || num2==1){
                num1 = num1+num2;
            }
            else{
                num1 = num1 * num2;
            }


        }

    }
}
