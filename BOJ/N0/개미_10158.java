package BOJ;

import java.util.Scanner;

public class 개미_10158 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int W = sc.nextInt();
		int H = sc.nextInt();
		
		int X = sc.nextInt();
		int Y = sc.nextInt();
		int T = sc.nextInt();
		
		int dx = 1; 
		int dy = 1;
		while(T >= 0) {
			X += dx;
			Y += dy;
			if(X == 0 || X == W) dx *= -1;
			if(Y == 0 || Y == H) dy *= -1;
			T--;
		}
		
		System.out.println(X + " " + Y);
	}
}
