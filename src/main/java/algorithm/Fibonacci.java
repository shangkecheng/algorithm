package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucaskc on 2017/5/17.
 */
public class Fibonacci {

    public int compute(int n) {
        int[] result = new int[n + 1];
        result[0] = 0;
        result[1] = 1;

        for (int i = 2; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }

        return result[n];
    }

    public int memorized(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0, 0);
        list.add(1, 1);
        return fab(n, list);
    }

    private int fab(int n, List<Integer> list) {
        if (list.size() > n) {
            return list.get(n);
        }else{
            int val = fab(n-1,list)+fab(n-2,list);
            list.add(n,val);
            return val;
        }


    }

}
