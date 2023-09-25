/*
 * 처음에 풀었을 때 정렬 안 해주고 막 풀었더니 시간복잡도 걸림
 * 일단 정렬부터 해주고 1. 거리가 같은 경우 2. 거리가 2m 3m인 경우 3. 거리가 2m 4m인 경우 4. 거리가 3m 4m인 경우 로 나누어서 확인
 * 
 */

import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Double, Integer> map = new HashMap<>();
        Arrays.sort(weights);
        for (int weight : weights) {
            double w1 = weight * 1.0;
            double w2 = (weight * 2.0) / 3.0;
            double w3 = (weight * 1.0) / 2.0;
            double w4 = (weight * 3.0) / 4.0;

            long count = 0;
            if (map.containsKey(w1))
                count += map.get(w1);
            if (map.containsKey(w2))
                count += map.get(w2);
            if (map.containsKey(w3))
                count += map.get(w3);
            if (map.containsKey(w4))
                count += map.get(w4);
            map.put(w1, map.getOrDefault(w1, 0) + 1);
            answer += count;
        }

        return answer;
    }
}