package myPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW1220 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		int t = Integer.valueOf(br.readLine());
		int[][] n = new int[100][100];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<100; i++) {
			int j = 0;
			while(st.hasMoreTokens()){
				n[i][j] = Integer.valueOf(st.nextToken());
				j++;
			}	
		}
		//1�� n�� (������) -> �Ʒ��� ���� (s�ؿ�) or 2�� ����
		//2�� s�� (�Ķ���)  -> ���� ���� (n�ؿ�) or 1�� ����
		
		for(int i = 0; i<100; i++) {
			for(int j = 0; j<100; j++) {
				if(j==0 && n[i][j] ==2)
					n[i][j] =0;
				
			}
		}
		
		
		
		
	}
}
