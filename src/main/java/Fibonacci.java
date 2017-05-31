/**
 * Created by lucaskc on 2017/5/17.
 */
public class Fibonacci {
    public static int compute(int n) {
//        } else {
//            result = compute(n - 1) + compute(n - 2);
//        }
        int [] result = new int [n+1];
        result[0]=0;
        result[1]=1;

        for(int i=2;i<=n;i++){
            result[i] = result[i-1]+result[i-2];
        }

        return result[n];
    }
}
