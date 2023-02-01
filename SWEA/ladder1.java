package SWEA;

import java.util.Scanner;

public class ladder1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {
			sc.nextInt();
			int[][] map = new int[100][100];
			int x = 99;
			int y = 0;
			for(int i=0; i<100; i++) {
				for(int j=0; j<100; j++) {
					map[i][j] = sc.nextInt();
					if(map[99][j] == 2) 
						y = j;
				}
			}
			while(x > 0) {
				int flag = 0;
				if(y + 1 < 100 && map[x][y+1] == 1) {
					flag = 1;
					while(y + 1 < 100 && map[x][y+1] == 1) y++;
				}
				if(flag == 0) 
					while(y-1 >=0 && map[x][y-1] == 1) y--;
				x--;
			}
			System.out.println("#" + tc + " " + y);
		}

	}

}
