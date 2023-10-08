import java.util.*;

class Solution {
    ArrayList<int[]> seq;

    public int[][] solution(int n) {
        seq = new ArrayList<>();

        hanoi(n, 1, 3, 2);

        int[][] answer = new int[seq.size()][2];
        for (int i = 0; i < seq.size(); i++) {
            answer[i][0] = seq.get(i)[0];
            answer[i][1] = seq.get(i)[1];
        }
        return answer;
    }

    public void hanoi(int n, int from, int to, int via) {
        if (n == 1) {
            seq.add(new int[] { from, to });
            return;
        }
        hanoi(n - 1, from, via, to);
        seq.add(new int[] { from, to });
        hanoi(n - 1, via, to, from);
    }
}