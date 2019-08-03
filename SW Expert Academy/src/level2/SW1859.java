package level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/* 백만 장자 프로젝트
 */
public class SW1859 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.valueOf(br.readLine());// enter the number of a test case
		int num = 0;
		while (num < t) {
			int i = 0;
			long temp = -1, max = -1;
			int n = Integer.valueOf(br.readLine());
			int[] price = new int[n];
			st = new StringTokenizer(br.readLine(), " ");
			long result = 0;
			while (st.hasMoreTokens()) {
				price[i] = Integer.valueOf(st.nextToken());
				i++;
			}
			
			for (int j = 0; j < n; j++) {
				if (temp >= j) {} 
				else {
					max = 0;
					for (int q = j; q < n; q++) {
						if (price[q] > max) {
							max = price[q];
							temp = q;
						}
					}
				}
				result = result + (max - price[j]);

			}
			sb.append("#" + (num + 1) + " " + result + "\n");
			num++;
		}
		System.out.println(sb);
	}
}
