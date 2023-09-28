/*
 * 공식이 중요했던 문제
 * 최대공약수를 써야하겠다 생각은 했는데 공식 유도까지는 실패했다
 * 공식은 w*h-(w+h-gcd)
 */
class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        answer = Long.valueOf(w) * Long.valueOf(h) - (w + h - getGCD(w, h));
        return answer;
    }

    public int getGCD(int w, int h) {
        int small = w;
        int big = h;

        if (big < small) {
            small = h;
            big = w;
        }

        int temp = 0;
        while (small > 0) {
            temp = big % small;
            big = small;
            small = temp;
        }

        return big;
    }
}