import java.util.*;

class Solution {

    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};

    private int bfs(char[][] map, int sy, int sx, int ty, int tx) {
        int r = map.length, c = map[0].length;
        int[][] dist = new int[r][c];
        for (int i = 0; i < r; i++) Arrays.fill(dist[i], -1);

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sy, sx});
        dist[sy][sx] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0], x = cur[1];

            if (y == ty && x == tx) return dist[y][x];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
                if (map[ny][nx] == 'X') continue;
                if (dist[ny][nx] != -1) continue;

                dist[ny][nx] = dist[y][x] + 1;
                q.add(new int[]{ny, nx});
            }
        }
        return -1; // 도달 불가
    }

    public int solution(String[] maps) {
        int r = maps.length, c = maps[0].length();
        char[][] map = new char[r][c];

        int sy = -1, sx = -1, ly = -1, lx = -1, ey = -1, ex = -1;

        for (int i = 0; i < r; i++) {
            map[i] = maps[i].toCharArray();
            for (int j = 0; j < c; j++) {
                char ch = map[i][j];
                if (ch == 'S') { sy = i; sx = j; }
                else if (ch == 'L') { ly = i; lx = j; }
                else if (ch == 'E') { ey = i; ex = j; }
            }
        }

        int d1 = bfs(map, sy, sx, ly, lx);
        if (d1 == -1) return -1;

        int d2 = bfs(map, ly, lx, ey, ex);
        if (d2 == -1) return -1;

        return d1 + d2;
    }
}