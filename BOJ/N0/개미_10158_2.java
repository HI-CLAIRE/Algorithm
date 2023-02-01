package BOJ;

import java.util.Scanner;

public class 개미_10158_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int W = sc.nextInt();
		int H = sc.nextInt();
		
		int X = sc.nextInt();
		int Y = sc.nextInt();
		int T = sc.nextInt();
		
		X += T % (W*2);
		Y += T % (H*2);
		
		if(X > W) 
			X = Math.abs(W*2 - X);
		if(Y > H)
			Y = Math.abs(H*2 - Y);
		
		System.out.println(X + " " + Y);
		
		sc.close();
	}

}
