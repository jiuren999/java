import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();

        List<Integer> row = new ArrayList<>();
        row.add(1);
        ret.add(row);
        for (int i = 1; i < numRows ; i++) {
            List<Integer> prevRow = ret.get(i-1);
            List<Integer> curRow = new ArrayList<>();
            curRow.add(1);

            for (int j = 1; j < i; j++) {
                int x = prevRow.get(j) + prevRow.get(j-1);
                curRow.add(x);
            }

            curRow.add(1);
            ret.add(curRow);
        }
        return ret;
    }
}

public class work {
    public static void main(String[] args) {

    }
}
