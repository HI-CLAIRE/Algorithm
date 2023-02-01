package 삼주차;

import java.util.Scanner;

public class 숫자로바꿔요_규연 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		int ans = 0;
		int sign = 1;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == '-') {
				sign = -1;
				continue;
			}
			ans = (ans * 10) + (str.charAt(i) - '0');
		}
		System.out.println(ans * sign);
		sc.close();
	}
}
