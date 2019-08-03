package myPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 승자 예측하기
 * Alice와 Bob 최선을 다해 경기
 * 1 1 4 4 16 16 64 64 순으로 순위 결정됨
 */
public class SW3459 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.valueOf(br.readLine());

		for (int i = 0; i < t; i++) {
			long n = Long.valueOf(br.readLine());
			long temp = 1;
			long preTemp = temp;
			long sum = 0;
			while (true) {
				if (n == 1) {
					sb.append("#" + (i + 1) + " Bob\n");

					break;
				} else {
					preTemp = temp;
					sum += preTemp;

					if (temp != 1)
						temp *= 4;
					else
						temp = 8;

					if ((n > preTemp) && n <= ((temp / 2) + sum)) {
						sb.append("#" + (i + 1) + " Alice\n");
						break;
					} else if (n > ((temp / 2) + preTemp) && (n <= temp + sum)) {
						sb.append("#" + (i + 1) + " Bob\n");

						break;
					}
				}

			}

		}
		System.out.println(sb);
	}
}