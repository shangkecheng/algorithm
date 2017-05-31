import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by lucaskc on 2017/5/23.
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        int maxProfit = 0;
        dfs(prices,list,0,0,0);
        //list.sort(Collections.reverseOrder());
        Collections.sort(list);
        return list.get(list.size()-1);
    }

    void dfs(int[] price,List<Integer> list,int pos, int profit,int num){
        if(pos == price.length-1 | num==2){
            list.add(profit);
        }
        for(int i=pos+1;i<price.length;i++){
            int margin = price[i]-price[pos];
            if(margin <0) {
                dfs(price,list,pos+1,profit,num);
            }else{
                dfs(price,list,i,profit+margin,num+1);
            }
        }
    }
}
