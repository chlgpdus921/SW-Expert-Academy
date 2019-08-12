package myPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 
 * 파도반 수열
 * d[0] = 0;
 * d[1] = 1;
 * d[2] = 1;
 * d[3] = 0 +1 
 * d[4] = 1 + 2
 * d[5] = 2 + 3 
 * d[6] = 3 + 4 
 * d[7] = 4 + 5
 * d[8] = 5 + 6
 *
 */
public class SW3376 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.valueOf(br.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.valueOf(br.readLine());
			long[] d = new long[n + 2];
			d[0] = 0;
			d[1] = 1;
			d[2] = 1;
			int preTemp = 1;
			for (int j = 3; j <= n; j = j + 2) {
				d[j] = d[preTemp - 1] + d[preTemp];
				d[j + 1] = d[preTemp] + d[preTemp + 1];
				preTemp += 2;
			}
			sb.append("#" + (i + 1) + " " + d[n] + "\n");
		}
		System.out.println(sb);

	}

}
