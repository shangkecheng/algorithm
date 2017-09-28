package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucaskc on 2017/5/20.
 */
public class AddOperator {

        public List<String> addOperators(String num, int target) {
            List<String> ans = new ArrayList<>();
            if(num ==null | (num != null ? num.length() : 0) ==0) {
                return ans;
            }
            dfs("",target,num,0,0,0,ans);
            return ans;
        }

        private void dfs(String path,int target,String num , int pos,
                         long cur, long prev, List<String> ans) {
                if(pos==num.length()){
                    if(cur==target){
                         ans.add(path);
                         return ;
                    }
                }
                for(int i=pos;i<num.length();i++){
                    if (num.charAt(pos) == '0' && i > pos) break;
                    String str = num.substring(pos,i+1);
                    long value= Long.valueOf(str);
                    if(pos ==0){
                        dfs( path + str,target,num,i+1,value,value,ans);
                    }else{
                        dfs( path +"+"+ str,target,num,i+1,cur+value,value,ans);
                        dfs( path +"-"+ str,target,num,i+1,cur-value,-value,ans);
                        dfs( path +"*"+ str,target,num,i+1,cur-prev+value*prev,
                                value*prev,ans);
                    }
                }

        }



}
