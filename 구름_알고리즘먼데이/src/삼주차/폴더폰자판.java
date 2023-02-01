package 삼주차;

import java.util.Scanner;

public class 폴더폰자판 {

	public static void main(String[] args) {
		char[][] p = new char[10][6];
		p[1] = new char[] {'1', '.', ',', '?', '!'};
		p[2] = new char[] {'2', 'A', 'B', 'C'};
		p[3] = new char[] {'3', 'D', 'E', 'F'};
		p[4] = new char[] {'4', 'G', 'H', 'I'};
		p[5] = new char[] {'5', 'J', 'K', 'L'};
		p[6] = new char[] {'6', 'M', 'N', 'O'};
		p[7] = new char[] {'7', 'P', 'Q', 'R', 'S'};
		p[8] = new char[] {'8', 'T', 'U', 'V'};
		p[9] = new char[] {'9', 'W', 'X', 'Y', 'Z'};
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String str = sc.next();
		
		char[] arr = new char[n];
		int[] cnt = new int[10];
		
		for(int i=0; i<n; i++) {
			arr[i] = str.charAt(i);
			cnt[arr[i]-'0']++;
		}
		
		for(int i=0; i<n; i++) {
			
		}
	} 

}
