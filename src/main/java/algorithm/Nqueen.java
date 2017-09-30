package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucaskc on 2017/5/24.
 */

public class Nqueen{
    public List<String[]> solveNQueens(int n) {
        ArrayList<String[]> res = new ArrayList<String[]>();
        helper(n,0,new ArrayList(), res);
        return res;
    }
    private void helper(int n, int row,  List<Integer> columnForRow, ArrayList<String[]> res)
    {
        if(row == n)
        {
            String[] item = new String[n];
            for(int i=0;i<n;i++)
            {
                StringBuilder strRow = new StringBuilder();
                for(int j=0;j<n;j++)
                {
                    if(columnForRow.get(i)==j)
                        strRow.append('Q');
                    else
                        strRow.append('.');
                }
                item[i] = strRow.toString();
            }
            res.add(item);
            return;
        }
        for(int i=0;i<n;i++)
        {
            columnForRow.add(i);
            if(check(row,columnForRow))
            {
                helper(n,row+1,columnForRow,res);
            }
            columnForRow.remove(columnForRow.size()-1);
        }
    }
    private boolean check(int row, List<Integer> columnForRow)
    {
        for(int i=0;i<row;i++)
        {
            if(columnForRow.get(i)==columnForRow.get(row) || Math.abs(columnForRow.get(row)-columnForRow.get(i))==row-i)
                return false;
        }
        return true;
    }

}

