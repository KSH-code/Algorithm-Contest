import java.util.*;
import java.io.*;

class Light {
  public int x, y, d;

  public Light (int x, int y, int d) {
    this.x = x;
    this.y = y;
    this.d = d;
  }
}

public class Main {
  private static int N, M;
  private static boolean arr[][];
  public static void main (String args[]) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str1[] = br.readLine().split(" ");
    N = Integer.parseInt(str1[0]);
    M = Integer.parseInt(str1[1]);

    arr = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      String str2 = br.readLine();
      for (int j = 0; j < M; j++) {
        arr[i][j] = str2.charAt(j) == '1';
      }
    }

    Queue<Light> q = new LinkedList<>();
    q.offer(new Light(0, 0, 2));
    // for (int i = 0; i < N; i++) {
    //   q.offer(new Light(i, 0, 2));
    // }
    // for (int i = 0; i < M; i++) {
    //   q.offer(new Light(N - 1, i, 1));
    // }
    // for (int i = 0; i < N; i++) {
    //   q.offer(new Light(N - i - 1, M - 1, 4));
    // }
    // for (int i = 0; i < M; i++) {
    //   q.offer(new Light(0, M - i - 1, 3));
    // }

    while (!q.isEmpty()) {
      Light l = q.poll();
      bw.write(getExitNumber(l) + " ");
    }

    bw.flush();
  }

  private static int getExitNumber (Light l) {
    while (true) {
      if (arr[l.x][l.y]) {
        l.d += l.d % 2 == 0 ? -1 : 1;
      }
      l.x += l.d == 1 ? -1 : l.d == 3 ? 1 : 0;
      l.y += l.d == 2 ? 1 : l.d == 4 ? -1 : 0;
      if (l.x < 0 || l.x >= N || l.y < 0 || l.y >= M) break;
    }
    if (l.d == 4) {
      return l.x + 1;
    }
    if (l.d == 3) {
      return N + l.y + 1;
    }
    if (l.d == 2) {
      return N + M + (N - l.x);
    }
    return 2 * N + M + (M - l.y);
  }
}
