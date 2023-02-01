package BOJ;

import java.util.Scanner;

public class 딱지놀이_14969 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int T = sc.nextInt();
		for(int tc=0; tc<T; tc++) {
			int[] cntA = new int[4];      //1, 2, 3, 4 갯수 저장 배열 및 초기화 
			
			int a = sc.nextInt();         //A의 딱지 갯수
			for(int i=0; i<a; i++) {
				int A = sc.nextInt() - 1; //딱지를 index로 접근 
				cntA[A]++;
			}
			
			int[] cntB = new int[4];      //B 초기화 
			int b = sc.nextInt();         //B의 딱지 갯수
			for(int i=0; i<b; i++) {
				int B = sc.nextInt() - 1;
				cntB[B]++;
			}
			
			for(int i=3; i>=0; i--) {     // 3210 순으로 비교 
				if(cntA[i] > cntB[i]) {
					System.out.println("A");
					break;
				}
				else if(cntA[i] < cntB[i]) {
					System.out.println("B");
					break;
				}
				else if(i == 0)
					System.out.println("D");
			}
					
		}
		sc.close();
	}
}
