package BOJ;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 회문1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1; tc<=1; tc++) {
			int n = sc.nextInt();
			String[] line = new String[8];
			Character[][] map = new Character[8][8];
			for(int i=0; i<8; i++) {
				line[i] = sc.next();
				for(int j=0; j<8; j++) {
					map[i][j] = line[i].charAt(j);
				}
			}
			for(int i=0; i<8; i++) {
				
				for(int j=i; i+j<8; j++) {
					
				}
			}
//			
//			System.out.println(cnt);
//			System.out.println("#" + tc + " " + cnt);
		}
		sc.close();
	}

}
