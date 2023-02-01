package B2;

import java.util.Scanner;

public class 분해합_2231 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int ans = 0;
		int N = sc.nextInt();
		for(int i=1; i<N; i++) {
			int tmp = i;
			int sum = 0;
			while(tmp > 0) {
				sum += tmp % 10;
				tmp /= 10;
			}
			if((sum + i) == N) {
				ans = i;
				break;
			}
		}
		System.out.println(ans);
		sc.close();
	}
}
