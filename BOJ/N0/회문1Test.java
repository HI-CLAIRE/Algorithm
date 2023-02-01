package BOJ;

import java.util.Scanner;

public class 회문1Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String[][] map = new String[8][8];
		for(int i=0; i<8; i++) 
			for(int j=0; j<8; j++)
				map[i][j] = sc.next();
		
		int cnt = 0;
		for(int i=0; i<8; i++) {
			String str = map[i].toString();
			String cmp = "";
			StringBuffer cmpsb = new StringBuffer(str);
			String rev = ""; 
			
			for(int j=i; i+j<8; j++) {
				for(int k=0; k<n; n++) {
					cmpsb.append(map[i][j]).toString();
				}
				rev = cmpsb.reverse().toString();
				if(cmpsb.equals(rev))
					cnt++;
			}
		}
		System.out.println(cnt);
	}

}
