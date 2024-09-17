package s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


class pro1 {

    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokenizer;

    public static void main(String[] args) throws IOException {
        String str = input.readLine();
        String result = "";
        String arr[] = divide(str);
        String u1 = arr[0];
        String v1 = arr[1];

        System.out.println(u1 + "&&" + v1);


        //System.out.println(check(u));
        if (check(u1)) { //올바른 괄호 문자열이라면
            result = result + u1;
            while (!v1.isEmpty()) { //v가 빌 때까지 검사
                String d[] = divide(v1);
                u1 = d[0];
                v1 = d[1];
                //System.out.println(u1 + "&&" + v1);
                result = result + u1 + v1;
            }
        }

        //boolean result = check(str);
        System.out.println(result);

    }
    //올바른 괄호 문자열 검사
    private static boolean check(String str){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '('){
                stack.push('(');

            }
            else if (str.charAt(i) == ')'){
                if(!stack.isEmpty()){
                    stack.pop();
                }
                else {
                    return false;
                }
            }
        }
        if(stack.isEmpty()) {
            return true;
        }
        return false;
    }
    //(()())()
    //u와 v로 분리해줌
    private static String[] divide(String str){
        //개수가 같은 균형잡힌 괄호 문자열

        int a=0, b =0, stop=0;
        String u="", v="";
        for(int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '('){
                a++;

            }
            else if (str.charAt(i) == ')'){
                b++;
            }
            u= u + str.charAt(i);
            if(a!=0 && b!=0 && a==b){
                stop=i;
                break;
            }
        }
        for(int j = stop+1; j < str.length(); j++){
            v = v + str.charAt(j);
        }

//        System.out.println(u);
//        System.out.println(v);
        return new String[]{u,v};
    }

}