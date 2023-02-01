package BOJ;

import java.util.Scanner;

public class ACM호텔_10250 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			
			int H = sc.nextInt();
			int W = sc.nextInt();
			int N = sc.nextInt();
			
			int guest = 0;
			for(int j=1; j<=W; j++) {
				for(int i=1; i<=H; i++) {
					guest++;
					if(guest == N)
						System.out.println(i*100 + j);
				}
			}
		}
		sc.close();
	}
}
