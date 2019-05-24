import java.util.*;
import java.io.*;

public class Main {
  public static void main (String args[]) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    String str[] = br.readLine().split(" ");

    int d[] = new int[N];
    int jump_counts[] = new int[N];
    for (int i = 0; i < N; i++) {
      d[i] = 123456789;
      jump_counts[i] = Integer.parseInt(str[i]);
    }
    d[0] = 0;
    for (int i = 0; i < N; i++) {
      if (d[i] == 123456789) continue;
      for (int j = 1; j <= jump_counts[i]; j++) {
        if (i + j < N && d[i + j]) {
          d[j] = Math.max(d[j], d[i] + 1);
        }
      }
    }
    System.out.println(Arrays.toString(d));
    bw.write(String.valueOf(d[N - 1] == 123456789 ? -1 : d[N - 1]));
    bw.flush();
  }
}
