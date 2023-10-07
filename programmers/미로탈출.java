import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int answer = 0;
        char[][] map = new char[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            map[i] = maps[i].toCharArray();
        }

        int startX = 0;
        int startY = 0;
        int leverX = 0;
        int leverY = 0;
        int endX = 0;
        int endY = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 'S') {
                    startX = i;
                    startY = j;
                }
                if (map[i][j] == 'L') {
                    leverX = i;
                    leverY = j;
                }
                if (map[i][j] == 'E') {
                    endX = i;
                    endY = j;
                }
            }
        }

        boolean[][] visited = new boolean[map.length][map[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { startX, startY, 0 });
        visited[startX][startY] = true;
        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };
        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            for (int i : new int[] { 0, 1, 2, 3 }) {
                int newX = position[0] + dx[i];
                int newY = position[1] + dy[i];
                if (newX >= 0 && newX < map.length && newY >= 0 && newY < map[0].length && map[newX][newY] != 'X') {
                    if (!visited[newX][newY]) {
                        if (map[newX][newY] == 'L') {
                            answer = position[2] + 1;
                            break;
                        }
                        visited[newX][newY] = true;
                        queue.add(new int[] { newX, newY, position[2] + 1 });
                    }
                }
                if (answer != 0) {
                    break;
                }
            }
        }

        if (answer == 0) {
            return -1;
        }

        visited = new boolean[map.length][map[0].length];
        queue = new LinkedList<>();
        queue.add(new int[] { leverX, leverY, answer });
        visited[leverX][leverY] = true;

        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            for (int i : new int[] { 0, 1, 2, 3 }) {
                int newX = position[0] + dx[i];
                int newY = position[1] + dy[i];

                if (newX >= 0 && newX < map.length && newY >= 0 && newY < map[0].length && map[newX][newY] != 'X'
                        && map[newX][newY] != 'L') {
                    if (!visited[newX][newY]) {
                        if (map[newX][newY] == 'E') {
                            return position[2] + 1;
                        }
                        visited[newX][newY] = true;
                        queue.add(new int[] { newX, newY, position[2] + 1 });
                    }
                }
            }
        }

        return -1;
    }
}