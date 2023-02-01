package B1;

import java.util.Scanner;

public class 쉽게푸는문제 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int[] arr = new int[1001];
		int cnt = 1;
		int numcnt = 0;
		for(int i=1; i<=1000; i++) {
			arr[i] = cnt;
			numcnt++;
			if(numcnt==cnt) {
				cnt++;
				numcnt = 0;
			}
		}
		int ans = 0;
		for(int i=a; i<=b; i++) {
			ans += arr[i];
		}
		System.out.println(ans);
	}

}
