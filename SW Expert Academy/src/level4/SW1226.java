package level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW1226 {
	static int[][] d, dupl;
	static int startX, startY, t;
	static StringBuilder sb = new StringBuilder();
	static boolean result = false;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int c = 0; c < 10; c++) {
			t = Integer.valueOf(br.readLine());
			/* input */
			result = false;
			d = new int[16][16];
			dupl = new int[16][16];
			for (int i = 0; i < 16; i++) {
				String temp = br.readLine();
				for (int j = 0; j < 16; j++) {
					d[i][j] = Integer.valueOf(temp.charAt(j) + "");
					if (d[i][j] == 2) {
						startX = i;
						startY = j;
					}
				}
			}
			/* Algorithm */
			mazeFirst(d[startX][startY - 1], startX, startY - 1, 0);
			mazeFirst(d[startX][startY + 1], startX, startY + 1, 1);
			mazeFirst(d[startX - 1][startY], startX - 1, startY, 2);
			mazeFirst(d[startX + 1][startY], startX + 1, startY, 3);
			
			if (!result)
				sb.append("#" + t + " 0\n");
		}
		System.out.println(sb);
	}

	static int[][] arr = new int[][] { 
		{ 0, -1 }, 
		{ 0, 1 }, 
		{ -1, 0 }, 
		{ 1, 0 } 
	};
	static int[][] s = new int[][] { 
		{ 0, 2, 3 }, // index = 0
		{ 1, 2, 3 }, // index = 1
		{ 2, 0, 1 }, // index = 2
		{ 3, 0, 1 } // index =3
	};
	
	public static int mazeFirst(int num, int startX, int startY, int index) {
		if( num ==1 )
			return 1;
		else if (startX - 1 < 0 || startX + 1 > 15 || startY - 1 < 0 || startY + 1 > 15)
			return 1;
		else if (dupl[startX][startY] == 4)//지나 온 길인지 확인
			return 1;
		else if (num == 0) {
			dupl[startX][startY] = 4;

			for (int p = 0; p < 3; p++) {
				int temp = s[index][p];
				int x = startX + arr[temp][0];
				int y = startY + arr[temp][1];
				
				mazeFirst(d[x][y], x, y, temp);
			}
		}
		else if(num ==3) {
			sb.append("#" + t + " 1\n");
			result = true;
			return 3;
		}
		return 1;
	}
}