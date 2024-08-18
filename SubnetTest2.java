import java.io.IOException;

public class SubnetTest2 {
    static int [] arr = {1,2,3,4,5};
    static int n = arr.length;
    public static void main(String[] args) throws IOException {
        for(int flag=0; flag< 1<<n; flag++){
            for(int i=0; i<n; i++){
                if((flag & 1<<i) !=0) System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
