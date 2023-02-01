package BOJ;

import java.util.Scanner;

public class 자리배정_10158_2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int Y = sc.nextInt();
		int X = sc.nextInt();
		int K = sc.nextInt();
		int[][] map = new int[X][Y];
		
		int x = X-1;
		int y =	0;
		int d = 0;
		int[][] dir = {{-1, 0},{0, 1},{1, 0},{0, -1}};

		if(K > X*Y) {
			System.out.println(0);
			sc.close();
			return; 
		}
		
		int cnt = 1;
		while(cnt != K) {			
			map[x][y] = cnt;
			int nx = x + (dir[d][0]);
			int ny = y + (dir[d][1]);
			
			if(nx>=X || ny>=Y || nx<0 || ny<0 || map[nx][ny] != 0) {
				d = (d+1) % 4;
				nx = x + (dir[d][0]);
				ny = y + (dir[d][1]);
				
			}
			
			x = nx;
			y = ny;
			
			cnt++;
			
		}
		System.out.println((y+1) + " " + (X-x));
//		System.out.println(d);
//		
//		for(int i=0; i<X; i++) {
//			for(int j=0; j<Y; j++) {
//				System.out.print(map[i][j] + " ");
//				
//			}
//			System.out.println();
//		}
		
		sc.close();
	}

}
