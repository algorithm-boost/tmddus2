
/*
 * Arrays.sort 쓸 때 직접 compare 함수 지정해서 쓸 수 있음
 * return 값이 양수일 때(꼭 1이 아니어도 됨) 순서가 바뀜
 * XOR 연산은 쉽게  ^ 기호를 사용해서 할 수 있다
 */
import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data, (a, b) -> compare(col - 1, a, b));
        for (int i = row_begin; i <= row_end; i++) {
            int s_i = 0;
            for (int d : data[i - 1]) {
                s_i += (d % i);
            }
            answer = answer ^ s_i;
        }
        return answer;
    }

    public int compare(int col, int[] a, int[] b) {
        if (a[col] < b[col]) // 오름차순 정렬
            return -1;
        if (a[col] == b[col]) {
            if (a[0] < b[0]) // 내림차순 정렬
                return 1; // 뒤에 오는 게 더 크니까 순서 바꿔주게 양수 리턴
            return -1;
        }
        return 1;
    }
}