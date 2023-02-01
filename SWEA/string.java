package SWEA;

import java.util.Scanner;

public class string {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc=1; tc<=10; tc++) {
			sc.nextInt();
			String cmp = sc.next();
			String str = sc.next();
			int words = 0;
			for(int i=0; i<str.length(); i++) {
				int j = 0;
				while(i+j < str.length() && str.charAt(i+j) == cmp.charAt(j)) {
					j++;
					if (j == cmp.length()) { 
						words++;
						break;
					}
				}
			}
			System.out.println("#" + tc + " " +  words);
		}
		sc.close();
	}
}
