package BOJ;

import java.util.Scanner;

public class 경비원_2564 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		int n = sc.nextInt();
		
		int[] shop = new int[n+1];
		for(int i=0; i<=n; i++) {   //n에 동근이 있음 
			int dir = sc.nextInt(); //북 동 남 서 1 4 2 3
			int pos = sc.nextInt(); //포지션 
			switch(dir) {
			case 1: shop[i] = pos;
					break;
			case 2: shop[i] = x + y + (x - pos);
					break;
			case 3: shop[i] = 2*x + y + (y - pos);
					break;
			case 4: shop[i] = x + pos;
					break;
			}
		}
		int sum = 0;
		for(int i=0; i<n; i++) {
			int min1 = Math.abs(shop[i] - shop[n]);
			int min2 = Math.abs((2*x + 2*y) - min1);
			int min = Math.min(min1, min2);
			sum += min;
		}
		System.out.println(sum);
		sc.close();
	}
}
