package BOJ;

import java.util.Scanner;

public class 자리배정_10157 {

	///////망한코드~~~~~~~~~~~~
	
	
	static boolean judgeDir(int[][] map, int x, int y, int dir, int X, int Y) {
		
		switch(dir) {
		case 0: x--; break;
		case 1: y++; break;
		case 2: x++; break;
		case 3: y--;
		}
		
		if(x>=X || y>=Y || x<0 || y<0 || map[x][y] != 0)
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int Y = sc.nextInt();
		int X = sc.nextInt();
		int K = sc.nextInt();
		int[][] map = new int[X][Y];
		
		int x = X-1;
		int y =	0;
		int dir = 0; // 상0 우1 하2 좌3
		if(K<=X*Y) {
			for(int n=1; n<=K; n++) {
				map[x][y] = n;
				if(judgeDir(map, x, y, dir, X, Y)) {
					dir = (dir+1) % 4;
						
					switch(dir) {
					case 0: x--; break;
					case 1: y++; break;
					case 2: x++; break;
					case 3: y--;
					}
				}
			}
			System.out.print((y+1) + " " + (X-1-x));
			System.out.println();
		}
		
		else
			System.out.println(0);
		for(int i=0; i<X; i++) {
			for(int j=0; j<Y; j++) {
				System.out.print(map[i][j] + " ");
				
			}
			System.out.println();
		}
		
		sc.close();
	}

}
