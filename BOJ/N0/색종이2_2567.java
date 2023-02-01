package BOJ;

import java.util.Scanner;

public class 색종이2_2567 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = 0;
		int y = 0;
		int[][] sq = new int[100][100];
		int num = sc.nextInt();
		for(int n=0; n<num; n++) {  //사각형을 1로 다 채움
			x = sc.nextInt();
			y = sc.nextInt();
			for(int i=x; i<x+10; i++)
				for(int j=y; j<y+10; j++)
					sq[i][j] = 1;
		}
		int cnt = 0;
		int[][] dir = {{-1, 0},{1, 0},{0, -1},{0, 1}};
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				for(int d = 0; d<dir.length; d++) {
					int nx = i + (dir[d][0]);
					int ny = j + (dir[d][1]);
					if(sq[i][j] == 1) {
						if (nx < 0 || nx > 99 || ny < 0 || ny > 99)
							cnt++; 
						else if(sq[nx][ny] == 0)
							cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
		sc.close();
	}
}
