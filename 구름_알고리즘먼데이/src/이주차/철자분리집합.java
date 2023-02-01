package 이주차;

import java.util.Scanner;

public class 철자분리집합 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String str = sc.next();
		
		int cnt = 1;
		for(int i=1; i<n; i++) {
			if(str.charAt(i-1) != str.charAt(i))
				cnt++;
		}
		
		System.out.println(cnt);
		
		sc.close();
	}

}
