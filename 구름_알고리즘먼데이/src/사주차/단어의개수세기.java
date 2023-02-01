package 사주차;

import java.util.Scanner;

public class 단어의개수세기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		int ans = 0;
		if(str.charAt(0) != ' ') ans++;
		for(int i=1; i<str.length(); i++) {
			if(str.charAt(i-1) == ' ' && str.charAt(i) != ' ') {
				ans++;
			}
			
		}
		System.out.println(ans);
		sc.close();
	}

}
